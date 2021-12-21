package com.example.videoplaydemo.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavViewModel: ViewModel() {

    var int = 0
    var text = MutableLiveData<String>().apply {
        value = "10000"
    }

    var text2 = ObservableField<String>()

    fun opp(){
        int += 95
        text2.set(int.toString())
    }

}