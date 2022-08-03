package com.example.value.data

import com.example.value.data.model.ResponseCloud
import retrofit2.http.GET

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ValueService {
    @GET("daily_json.js")
    suspend fun fetchValues() : ResponseCloud
}