package com.dallmeier.core

import com.dallmeier.presentation.weather.WeathersFragment
import dagger.hilt.android.AndroidEntryPoint

object FragmentFactory{
    fun getWeatherFragment(supportFragmentManager: androidx.fragment.app.FragmentManager): WeathersFragment {
        var fragment = supportFragmentManager.findFragmentByTag(WeathersFragment.FRAGMENT_NAME)
        if (fragment == null) {
            fragment = WeathersFragment()
        }
        return fragment as WeathersFragment
    }

}