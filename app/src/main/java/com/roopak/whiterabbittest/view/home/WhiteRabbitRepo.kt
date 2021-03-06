package com.roopak.whiterabbittest.view.home

import com.roopak.whiterabbittest.api.service.ApiInterface
import com.roopak.whiterabbittest.models.ApiResponse
import com.roopak.whiterabbittest.models.Profiles
import retrofit2.Retrofit

class WhiteRabbitRepo(private val retrofit: Retrofit) {
    suspend fun getDataFromCloud() : List<Profiles>? {
        val service = retrofit.create(ApiInterface::class.java)
        val respnse = service.hitCountCheck()
        if(respnse.isSuccessful){
            return respnse.body()
        }else{
            throw Exception(respnse.message())
        }

    }
}