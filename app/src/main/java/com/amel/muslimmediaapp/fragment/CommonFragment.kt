package com.amel.muslimmediaapp.fragment

import androidx.fragment.app.Fragment
import com.NewsViewModel
import com.amel.muslimmediaapp.databinding.FragmentCommonBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CommonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommonFragment : Fragment() {
    private var _binding: FragmentCommonBinding? = null
    private val binding get() = _binding as FragmentCommonBinding

    private var _commonNewsViewModel: NewsViewModel? = null
    private val commonNewsViewModel get() = _commonNewsViewModel as NewsViewModel

}