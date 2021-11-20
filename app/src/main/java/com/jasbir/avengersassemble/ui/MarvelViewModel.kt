package com.jasbir.avengersassemble.ui

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jasbir.neumtechassignment.data.remote.NetworkHandler
import com.jasbir.repository.remote.response.MarvelCharacters
import com.jasbir.repository.remote.response.MarvelCharacters.Data.CharacterResult
import com.jasbir.repository.repo.MarvelRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel
@Inject constructor(private val marvelRepositoryImpl: MarvelRepositoryImpl) : ViewModel() {

    var getMarvelCharacters: MutableLiveData<NetworkHandler<MarvelCharacters>> = MutableLiveData()

    fun invokeCharacterApi() {
        viewModelScope.launch(Dispatchers.IO) {

            val response = marvelRepositoryImpl.invokeCharactersApi()
            withContext(Dispatchers.Main) {
                getMarvelCharacters.value = response
            }
        }

    }

    fun fetchCharactersLiveData(): Flow<PagingData<CharacterResult>> {
        return marvelRepositoryImpl.getCharacterLiveData()
            .cachedIn(viewModelScope)
    }

    /*  fun fetchCharactersLiveData(): LiveData<PagingData<MarvelCharacters.Data.Result>> {
          return marvelRepositoryImpl.getCharacterLiveData()
              .map {
                  it
              }
              .cachedIn(viewModelScope)
      }*/


/*fun invokeCharacterApi(){
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