package com.example.videoplaydemo.network

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/dab1e/json/user")
    suspend fun get():List<User>
}

interface ApiHelper{
    suspend fun getUser():List<User>
}

data class User(@SerializedName("user")var user:String,
                @SerializedName("age") var age:Int,
                @SerializedName("firstname") var firstname:String,
                @SerializedName("lastname") var lastname:String
)
