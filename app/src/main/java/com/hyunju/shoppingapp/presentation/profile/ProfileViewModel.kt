package com.hyunju.shoppingapp.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hyunju.shoppingapp.data.preference.PreferenceManager
import com.hyunju.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProfileViewModel(
    private val preferenceManager: PreferenceManager
) : BaseViewModel() {

    private var _profileStateLiveData = MutableLiveData<ProfileState>(ProfileState.Uninitialized)
    val profileStateLiveData: LiveData<ProfileState> = _profileStateLiveData

    override fun fetchDate(): Job = viewModelScope.launch {
        setState(ProfileState.Loading)
        preferenceManager.getIdToken()?.let {
            setState(
                ProfileState.Login(it)
            )
        }?:run {
            setState(
                ProfileState.Success.NotRegistered
            )
        }
    }

    private fun setState(state: ProfileState) {
        _profileStateLiveData.postValue(state)
    }


}