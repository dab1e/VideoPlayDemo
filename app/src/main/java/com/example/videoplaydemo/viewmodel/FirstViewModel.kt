package com.example.videoplaydemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videoplaydemo.network.Repository
import com.example.videoplaydemo.network.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repo: Repository) : ViewModel() {

    var listUser = MutableLiveData<List<User>>()

    fun getUser(): MutableLiveData<List<User>> {
        viewModelScope.launch {
            listUser.value = repo.getUser()
            this@FirstViewModel.listUser
        }
        return listUser
    }

}