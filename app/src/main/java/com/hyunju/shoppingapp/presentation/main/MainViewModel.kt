package com.hyunju.shoppingapp.presentation.main

import androidx.lifecycle.viewModelScope
import com.hyunju.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class MainViewModel : BaseViewModel() {

    override fun fetchDate(): Job = viewModelScope.launch {

    }
}