package com.example.videoplaydemo.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.navGraphViewModels
import com.example.videoplaydemo.R
import com.example.videoplaydemo.databinding.SecondFragmentBinding
import com.example.videoplaydemo.viewmodel.NavViewModel
import com.example.videoplaydemo.viewmodel.SecondViewModel

class SecondFragment : Fragment() {

    val viewModelNav: NavViewModel by navGraphViewModels(R.id.navi_graph)
    val viewmodel: NavViewModel by activityViewModels()
    private lateinit var binding : SecondFragmentBinding

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(layoutInflater)
        binding.viewmodel = viewModelNav
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        viewModelNav.text.observe(viewLifecycleOwner,Observer{
            binding.txtViewModel.text = viewModelNav.text.value.toString()
        })


    }

}