package com.example.videoplaydemo.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.videoplaydemo.R
import com.example.videoplaydemo.databinding.LastFragmentBinding
import com.example.videoplaydemo.viewmodel.FirstViewModel
import com.example.videoplaydemo.viewmodel.LastViewModel
import com.example.videoplaydemo.viewmodel.NavViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class LastFragment : Fragment() {

    private lateinit var binding: LastFragmentBinding
    private lateinit var viewModel: LastViewModel
    val viewModelNav: NavViewModel by navGraphViewModels(R.id.navi_graph)
    val viewmodel : LastViewModel by navGraphViewModels(R.id.navi_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Lifecycle", "LastFragment onCreateView")
        binding = LastFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("Lifecycle", "LastFragment onActivityCreated")
        viewModel = ViewModelProvider(this).get(LastViewModel::class.java)

        viewModelNav.text.observe(viewLifecycleOwner, Observer{
            binding.txtViewModel.text = viewModelNav.text.value.toString()
        })
        val title = arguments?.getString("title")
        val result = (title?.toLong()?:5000)-5000
        binding.title.text = "$title - 5000 = ${result}"

        findNavController().previousBackStackEntry?.savedStateHandle?.set("key",result)

        binding.startSecondFragment.setOnClickListener {
            findNavController().navigate(R.id.action_lastFragment_to_secondFragment)
        }

//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
//            OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                passData(result)
//            }
//            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Lifecycle", "LastFragment onViewCreated")

    }

    fun passData(num:Long){
        val action = LastFragmentDirections.actionLastFragmentToFirstFragment(num)
        this.view?.findNavController()?.navigate(action)
    }

    override fun onStart() {
        super.onStart()
        Log.e("Lifecycle", "LastFragment onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Lifecycle", "LastFragment onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Lifecycle", "LastFragment onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Lifecycle", "LastFragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Lifecycle", "LastFragment onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("Lifecycle", "LastFragment onDetach")
    }

    override fun onDestroy() {
        Log.e("Lifecycle", "LastFragment onDestroy")
        super.onDestroy()
    }


}



