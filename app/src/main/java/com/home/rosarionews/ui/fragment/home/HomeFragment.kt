package com.home.rosarionews.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.home.rosarionews.R
import com.home.rosarionews.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    private var uiStateJob: Job? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.newsLiveData.observe(this, Observer {
            binding.rvNews.adapter = MainAdapter(it.toMutableList())
        })
        initViews()
    }

    override fun onStart() {
        super.onStart()
       /* uiStateJob = lifecycleScope.launchWhenStarted {
            viewModel.newsStateFlow.collect {
                binding.rvNews.adapter = MainAdapter(it.toMutableList())
                binding.nsvMain.scrollTo(0, 0)
            }
        }*/
    }

    override fun onStop() {
        uiStateJob?.cancel()
        super.onStop()
    }

    private fun initViews() {
        binding.tvSearch.setOnClickListener {
            findNavController().navigate(R.id.actionSearch)
        }
    }
}