package com.example.videoplaydemo.common

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoplaydemo.adapter.RecyclerViewUserAdapter
import com.example.videoplaydemo.network.User
import javax.inject.Inject

@Inject
lateinit var lifecycleOwner: ActivityModule

@BindingAdapter("bindingAdapterUser")
fun bindingAdapterUser(recycler: RecyclerView, list: MutableLiveData<List<User>>){

    list.observe( lifecycleOwner.provideLifecycleOwner(), Observer{
        val adapter = RecyclerViewUserAdapter(it)
        recycler.adapter = adapter
    })
}