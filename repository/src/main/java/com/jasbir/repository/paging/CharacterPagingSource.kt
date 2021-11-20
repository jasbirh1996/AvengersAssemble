package com.example.pagingv3demo

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jasbir.repository.remote.response.MarvelCharacters
import com.jasbir.repository.remote.response.MarvelCharacters.Data.CharacterResult
import com.jasbir.repository.remote.service.ApiInterface
import com.jasbir.repository.remote.service.MarvelConstants
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject


class CharacterPagingSource
@Inject
constructor(private val apiInterface: ApiInterface) :
    PagingSource<Int, CharacterResult>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResult> {
        val currentPageKey = params.key ?: 0
        val limit = 20
        return try {
            val timestamp = getTimeStamp()
            val hashkey =
                "${timestamp}${MarvelConstants.MARVEL_API_PRIVATE_KEY}${MarvelConstants.MARVEL_API_PUBLIC_KEY}"
            val hash = md5(hashkey)

            val response = apiInterface.getCharacters(timestamp, MarvelConstants.MARVEL_API_PUBLIC_KEY, hash, limit, currentPageKey * limit).body()
            val charactersList = response?.data?.charactersList
            LoadResult.Page(
                data = charactersList!!,
                prevKey = if (currentPageKey == 0) null else currentPageKey - 1,
                nextKey = if (charactersList.isNullOrEmpty()) null else currentPageKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterResult>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    }


    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }


    fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun getTimeStamp(): String {
        val timestamp = Timestamp(System.currentTimeMillis())
        Log.d("TIME_STAMP", "$timestamp")
        return timestamp.toString()
    }


}