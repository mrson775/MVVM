package com.dallmeier.core

import com.dallmeier.presentation.nfc.NfcFragment
import com.dallmeier.presentation.weather.WeathersFragment
import dagger.hilt.android.AndroidEntryPoint

object FragmentFactory{
    fun getWeatherFragment(supportFragmentManager: androidx.fragment.app.FragmentManager):  NfcFragment {
        var fragment = supportFragmentManager.findFragmentByTag(WeathersFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = NfcFragment()
        }
        return fragment as  NfcFragment
    }

}