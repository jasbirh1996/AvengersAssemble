package com.jasbir.avengersassemble.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jasbir.neumtechassignment.data.remote.NetworkHandler
import com.jasbir.repository.remote.response.MarvelCharacters
import com.jasbir.repository.repo.MarvelRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel
@Inject constructor(private val marvelRepositoryImpl: MarvelRepositoryImpl) : ViewModel() {

    var getMarvelCharacters : MutableLiveData<NetworkHandler<MarvelCharacters>> = MutableLiveData()

    fun invokeCharacterApi(){
        viewModelScope.launch(Dispatchers.IO) {

            val response = marvelRepositoryImpl.invokeCharactersApi()
            withContext(Dispatchers.Main){
                getMarvelCharacters.value = response
            }
        }

    }/*fun invokeCharacterApi(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = marvelRepositoryImpl.impApicall()
            try {
                getMarvelCharacters.value = NetworkHandler.Success(response)

            }catch (e: Exception){
                getMarvelCharacters.value = NetworkHandler.Error(e.toString())
            }
        }

    }*/
}