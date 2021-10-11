package com.jasbir.repository.repo

import com.jasbir.neumtechassignment.data.remote.NetworkHandler
import com.jasbir.repository.remote.response.MarvelCharacters

interface MarvelRepository {



    suspend fun invokeCharactersApi(): NetworkHandler<MarvelCharacters>

    suspend fun invokeCharacterSearchApi()

    suspend fun storeSearchedCharacterQuery()

    suspend fun getSearchedCharacterQueries()

    suspend fun invokeComicsApi()

}