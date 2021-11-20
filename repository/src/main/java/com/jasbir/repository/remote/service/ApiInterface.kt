package com.jasbir.repository.remote.service

import com.jasbir.repository.remote.response.MarvelCharacters

import retrofit2.Response
import retrofit2.http.*
import java.sql.Timestamp

interface ApiInterface {

//    @GET("characters?apikey=$MARVEL_API_PUBLIC_KEY&ts=$MARVEL_API_TS&hash=$MARVEL_API_HASH")
//    suspend fun getCharacters(): Response<MarvelCharacters>

 @GET("characters?")
 suspend fun getCharacters(@Query("ts") timestamp: String,
                           @Query("apikey") apikey: String,
                           @Query("hash") hash: String,
                           @Query("limit") limit : Int,
                           @Query("offset") offset: Int, ): Response<MarvelCharacters>

}