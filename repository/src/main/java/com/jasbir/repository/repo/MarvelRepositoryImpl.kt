package com.jasbir.repository.repo

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingv3demo.CharacterPagingSource
import com.jasbir.neumtechassignment.data.remote.NetworkHandler
import com.jasbir.repository.remote.response.MarvelCharacters
import com.jasbir.repository.remote.response.MarvelCharacters.Data.CharacterResult
import com.jasbir.repository.remote.service.ApiInterface
import com.jasbir.repository.remote.service.MarvelConstants.DEFAULT_PAGE_SIZE_CHARACTER
import kotlinx.coroutines.flow.Flow
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject
constructor(private val apiInterface: ApiInterface, private  val characterPagingSource: CharacterPagingSource) : MarvelRepository {
    var data: MarvelCharacters? = null


    override suspend fun invokeCharactersApi():NetworkHandler<MarvelCharacters> {
        TODO("Not yet implemented")
  /*      return try {
            val timestamp = getTimeStamp()
            val hashkey = "${timestamp}${MarvelConstants.MARVEL_API_PRIVATE_KEY}$MARVEL_API_PUBLIC_KEY"
            val hash = md5(hashkey)
            Log.d("haskey","$hash")
            val data = apiInterface.getCharacters(timestamp,MARVEL_API_PUBLIC_KEY,hash,1,1)
            NetworkHandler.Success(data)
            if (data.isSuccessful){
                NetworkHandler.Success(data.body()!!)
            } else {
                NetworkHandler.Error(data.message())
            }
        } catch (e: Exception){
            NetworkHandler.Error(e.toString())
        }*/
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

/*    fun getCharacterLiveData(pagingConfig: PagingConfig = getDefaultPageConfig()): LiveData<PagingData<MarvelCharacters.Data.Result>> {
        val pager = Pager(
            config = pagingConfig,
            pagingSourceFactory = { characterPagingSource }
        )
        return pager.flow.asLiveData()
    }*/

    fun getCharacterLiveData(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<CharacterResult>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { characterPagingSource }
        ).flow
    }

    fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE_CHARACTER, enablePlaceholders = false)
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