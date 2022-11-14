package com.example.marsapp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Headers.Companion.toHeaders
import retrofit2.create

private const val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"


@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}



object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

class DefaultMarsPhotoRepositary(): MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }
}
