package com.hyunju.shoppingapp.presentation.profile

import androidx.lifecycle.viewModelScope
import com.hyunju.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProfileViewModel : BaseViewModel() {

    override fun fetchDate(): Job = viewModelScope.launch {

    }
}