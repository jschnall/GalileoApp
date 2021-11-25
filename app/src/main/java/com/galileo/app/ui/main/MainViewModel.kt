package com.galileo.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galileo.app.repo.CowboyWisdomRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(val cowboyWisdomRepo: CowboyWisdomRepo) : ViewModel() {
    private val _content = MutableStateFlow("")
    val content: StateFlow<String?> get() = _content

    fun onCloseClicked() {
        _content.value = ""
    }

    fun onButtonClicked() {
        viewModelScope.launch {
            _content.value = cowboyWisdomRepo.fetchWisdom()
        }
    }
}