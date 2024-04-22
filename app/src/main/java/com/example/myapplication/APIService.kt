package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("api/v2/content/users")
    fun getListOfUsers() : Call<ArrayList<Data>>

}