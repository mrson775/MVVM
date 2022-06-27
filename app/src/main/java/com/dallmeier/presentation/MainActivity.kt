package com.dallmeier.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dallmeier.core.FragmentFactory
import com.dallmeier.myapplication.R
import com.dallmeier.presentation.weather.WeathersFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showHomeFragment()
    }
    private fun showHomeFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                FragmentFactory.getWeatherFragment(supportFragmentManager),
                WeathersFragment.FRAGMENT_NAME)
        fragmentTransaction.addToBackStack(WeathersFragment.FRAGMENT_NAME)
        fragmentTransaction.commit()
    }
}