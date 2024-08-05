package com.example.artspace

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.artspace.data.Artwork
import com.example.artspace.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ArtSpaceViewModel : ViewModel() {
    private val _pictures = MutableStateFlow(DataSource.artworks)
    val pictures = _pictures.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex = _currentIndex.asStateFlow()

    private val _currentArtwork = MutableStateFlow(_pictures.value[0])
    val currentArtwork = _currentArtwork.asStateFlow()


    fun updateCurrentArtwork() {
        _currentArtwork.value = _pictures.value[_currentIndex.value]

    }

    fun nextArtwork() {
        if(_currentIndex.value != _pictures.value.lastIndex) {
            _currentIndex.value++
            updateCurrentArtwork()
        } else {
            _currentIndex.value = 0
            updateCurrentArtwork()
        }
    }

    fun previousArtwork() {
        if (_currentIndex.value != 0) {
            _currentIndex.value--
            updateCurrentArtwork()
        } else {
            _currentIndex.value = _pictures.value.lastIndex
            updateCurrentArtwork()
        }
    }
}
