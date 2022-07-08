package com.hyunju.shoppingapp.presentation.list

import androidx.lifecycle.viewModelScope
import com.hyunju.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductListViewModel : BaseViewModel() {

    override fun fetchDate(): Job = viewModelScope.launch {

    }
}