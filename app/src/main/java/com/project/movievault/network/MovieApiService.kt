package com.project.movievault.network

import com.project.movievault.model.ShowResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.tvmaze.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("search/shows?q=all")
    suspend fun getShowResponses(): List<ShowResponse>
}

object MoviesApi {
    val retrofitService: MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}