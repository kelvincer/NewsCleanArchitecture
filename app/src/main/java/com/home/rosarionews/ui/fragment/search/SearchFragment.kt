package com.home.rosarionews.ui.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.home.rosarionews.R
import com.home.rosarionews.databinding.FragmentHomeBinding
import com.home.rosarionews.databinding.FragmentSearchBinding
import com.home.rosarionews.ui.fragment.home.MainViewModel
import kotlinx.coroutines.Job

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private var uiStateJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }
}