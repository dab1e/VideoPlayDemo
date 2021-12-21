package com.example.videoplaydemo.network

import javax.inject.Inject

class ApiHelperImlp @Inject constructor(private val apiService: ApiService): ApiHelper {
    override suspend fun getUser(): List<User> = apiService.get()
}