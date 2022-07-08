package com.hyunju.shoppingapp.presentation.profile

import com.hyunju.shoppingapp.databinding.FragmentProfileBinding
import com.hyunju.shoppingapp.presentation.BaseFragment
import org.koin.android.ext.android.inject

internal class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    companion object {
        const val TAG = "ProfileFragment"
    }

    override val viewModel by inject<ProfileViewModel>()

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override fun observeData() {
    }
}