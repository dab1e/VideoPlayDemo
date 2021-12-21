package com.example.videoplaydemo.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.videoplaydemo.R
import com.example.videoplaydemo.viewmodel.FragmentMainViewModel

class FragmentMain : Fragment() {

    companion object {
        fun newInstance() = FragmentMain()
    }

    private lateinit var viewModel: FragmentMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}