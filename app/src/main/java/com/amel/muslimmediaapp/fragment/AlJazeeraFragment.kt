package com.amel.muslimmediaapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.NewsViewModel
import com.amel.muslimmediaapp.adapter.NewsAdapter
import com.amel.muslimmediaapp.databinding.FragmentAlJazeeraBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AlJazeeraFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlJazeeraFragment : Fragment() {
    private var _binding: FragmentAlJazeeraBinding? = null
    private val binding get() = _binding as FragmentAlJazeeraBinding

    private var _alJazeeraNewsModel: NewsViewModel? = null
    private val alJazeeraNewsViewModel get() = _alJazeeraNewsModel as NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlJazeeraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _alJazeeraNewsModel = ViewModelProvider(this)[NewsViewModel::class.java]
        alJazeeraNewsViewModel.alJazeeraNews()
        alJazeeraNewsViewModel.alJazeeraNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i(
                "AboutAlJazeeraFragment",
                "onViewCreated: ${it.articles}"
            )
            binding.rvAlJazeera.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}