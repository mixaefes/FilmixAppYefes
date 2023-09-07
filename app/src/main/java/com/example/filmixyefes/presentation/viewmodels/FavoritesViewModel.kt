package com.example.filmixyefes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmixyefes.data.FilmsRepository
import com.example.filmixyefes.data.local.FavoriteFilm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: FilmsRepository) :
    ViewModel() {

    private var _allFavoritesFilms = MutableStateFlow<List<FavoriteFilm>>(emptyList())
    val allFavoritesFilms get() = _allFavoritesFilms

    init {
        getAllFavoritesFilms()
    }

    private fun getAllFavoritesFilms() {
        viewModelScope.launch(Dispatchers.IO) {
             repository.allFavoritesFilms.collectLatest {
                 _allFavoritesFilms.value = it
            }
        }
    }
}