package com.example.videoplaydemo.network

import javax.inject.Inject

class Repository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUser() = apiHelper.getUser()
}