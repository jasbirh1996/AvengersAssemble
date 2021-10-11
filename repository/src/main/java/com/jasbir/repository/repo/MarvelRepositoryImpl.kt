package com.jasbir.repository.repo

import android.util.Log
import com.jasbir.neumtechassignment.data.remote.NetworkHandler
import com.jasbir.repository.remote.response.MarvelCharacters
import com.jasbir.repository.remote.service.ApiInterface
import com.jasbir.repository.remote.service.MarvelConstants
import com.jasbir.repository.remote.service.MarvelConstants.MARVEL_API_PUBLIC_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject
constructor(private val apiInterface: ApiInterface) : MarvelRepository {
    var data: MarvelCharacters? = null


    override suspend fun invokeCharactersApi():NetworkHandler<MarvelCharacters> {
        return try {
            val timestamp = getTimeStamp()
            val hashkey = "${timestamp}${MarvelConstants.MARVEL_API_PRIVATE_KEY}$MARVEL_API_PUBLIC_KEY"
            val hash = md5(hashkey)
            Log.d("haskey","$hash")
            val data = apiInterface.getCharacters(timestamp,MARVEL_API_PUBLIC_KEY,hash)
            NetworkHandler.Success(data)
            if (data.isSuccessful){
                NetworkHandler.Success(data.body()!!)
            } else {
                NetworkHandler.Error(data.message())
            }
        } catch (e: Exception){
            NetworkHandler.Error(e.toString())
        }
    }

    override suspend fun invokeCharacterSearchApi() {
        TODO("Not yet implemented")
    }

    override suspend fun storeSearchedCharacterQuery() {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchedCharacterQueries() {
        TODO("Not yet implemented")
    }

    override suspend fun invokeComicsApi() {
        TODO("Not yet implemented")
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun getTimeStamp(): String {
        val timestamp = Timestamp(System.currentTimeMillis())
        Log.d("TIME_STAMP", "$timestamp")
        return  timestamp.toString()
    }


}