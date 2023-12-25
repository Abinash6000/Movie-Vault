package com.project.movievault.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.movievault.model.ShowResponse
import com.project.movievault.network.MoviesApi
import kotlinx.coroutines.launch

enum class MovieApiStatus {
    LOADING, ERROR, DONE
}

class MovieViewModel : ViewModel() {

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> get() = _status

    private val _shows = MutableLiveData<List<ShowResponse>>()
    val shows: LiveData<List<ShowResponse>> get() = _shows

    init {
        getShowResponses()
    }

    private fun getShowResponses() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _shows.value = MoviesApi.retrofitService.getShowResponses()
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                Log.d("abcd",e.toString())
                _status.value = MovieApiStatus.ERROR
                _shows.value = listOf()
            }
        }
    }
}