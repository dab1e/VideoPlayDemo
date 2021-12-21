package com.example.videoplaydemo.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videoplaydemo.R
import com.example.videoplaydemo.adapter.RecyclerViewUserAdapter
import com.example.videoplaydemo.databinding.FirstFragmentBinding
import com.example.videoplaydemo.viewmodel.FirstViewModel
import com.example.videoplaydemo.viewmodel.NavViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment  : Fragment() {

    private lateinit var binding: FirstFragmentBinding
    private lateinit var viewModel: FirstViewModel
    val viewModelNav: NavViewModel by navGraphViewModels(R.id.navi_graph)
    private lateinit var adapter: RecyclerViewUserAdapter
    private val args : FirstFragmentArgs by navArgs()
    val firstViewModel : FirstViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Lifecycle", "onCreateView")
        binding = FirstFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("Lifecycle", "onActivityCreated")
        viewModel = ViewModelProvider(requireActivity()).get(FirstViewModel::class.java)

//        viewModel.getUser().observe(viewLifecycleOwner, Observer {
//
//            binding.rcUser.apply {
//                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
//                adapter = RecyclerViewUserAdapter(it)
//            }
//        })


        viewModelNav.text.observe(viewLifecycleOwner, Observer{
            binding.txtViewmodel.text = viewModelNav.text.value.toString()
        })

        binding.edtTitle.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModelNav.text.value = binding.edtTitle.text.toString()
            }

        })
//        adapter = RecyclerViewUserAdapter(list)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("Lifecycle", "onViewCreated")
        findNavController().getBackStackEntry(R.id.firstFragment).savedStateHandle.getLiveData<Long>("key")
            .observe(viewLifecycleOwner){
                binding.edtTitle.setText(it.toString())
            }
//        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Long>("key")
//            ?.observe(viewLifecycleOwner){respone->
//
//                binding.edtTitle.setText(respone.toString())
//            }
        binding.startLastActivity.setOnClickListener {
            val title = binding.edtTitle.text
            var bundle = Bundle().apply {
                putString("title",title.toString())
            }
            findNavController().navigate(R.id.action_firstFragment_to_lastFragment, bundle)
        }
        binding.startSecondFragment.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }



    }

    override fun onStart() {
        super.onStart()
        Log.e("Lifecycle", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Lifecycle", "onPause")
    }

    override fun onResume() {
        super.onResume()
//        val txt = args.result.toString()
//        binding.edtTitle.setText(txt)
        Log.e("Lifecycle", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Lifecycle", "onStop")
    }

    override fun onDestroyView() {
        Log.e("Lifecycle", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("Lifecycle", "onDetach")
    }

}