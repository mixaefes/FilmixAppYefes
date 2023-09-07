package com.example.filmixyefes.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmixyefes.data.FilmsRepository
import com.example.filmixyefes.data.local.FavoriteFilm
import com.example.filmixyefes.model.FilmItem
import com.example.filmixyefes.model.PopularFilmsList
import com.example.filmixyefes.utils.Constants.EMPTY_FILM_ITEM
import com.example.filmixyefes.utils.Constants.EMPTY_FILM_LIST_RESULT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: FilmsRepository,
) : ViewModel() {

    private var _isShowNowPlayingFilms by mutableStateOf(false)
    private var _currentPage by mutableStateOf(1)
    private var _popularFilmsList = MutableStateFlow(EMPTY_FILM_LIST_RESULT)
    private var _currentFilm: MutableStateFlow<FilmItem> = MutableStateFlow(EMPTY_FILM_ITEM)

    val currentFilm get() = _currentFilm
    val currentPage get() = _currentPage
    val popularFilmsList: StateFlow<PopularFilmsList> get() = _popularFilmsList
    val isShowNowPlayingFilms get() = _isShowNowPlayingFilms

    init {
        viewModelScope.launch {
            Log.d("ViewModel", "init")
            getPopularFilmsList(_currentPage)
        }
    }

    fun addItemToFavorites(film: FavoriteFilm) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFavoriteFilm(film)
        }
    }

    private fun getNowPlatingFilmsList(page: Int) {
        viewModelScope.launch {
            repository.getNowPlayingFilms(page)
                .collectLatest {
                    _popularFilmsList.value = it
                }
        }
    }

    private fun getPopularFilmsList(page: Int) {
        viewModelScope.launch {
            repository.getPopularFilms(page)
                .collectLatest {
                    _popularFilmsList.value = it
                }
        }
    }

    fun setCurrentFilmId(filmId: Int) {
        viewModelScope.launch {
            _popularFilmsList.value.results.find {
                it.id == filmId
            }?.let {
                _currentFilm.value = it
            }
        }
    }

    fun setIsShowNowPlayingFilmsList() {
        _isShowNowPlayingFilms = !_isShowNowPlayingFilms
        getFilmsList()
    }

    fun onNextPage() {
        _currentPage++
        getFilmsList()
    }
    fun onPrevPage() {
        _currentPage--
        getFilmsList()
    }

    private fun getFilmsList() {
        if (!_isShowNowPlayingFilms) {
            getPopularFilmsList(_currentPage)
        } else {
            getNowPlatingFilmsList(_currentPage)
        }
    }

}