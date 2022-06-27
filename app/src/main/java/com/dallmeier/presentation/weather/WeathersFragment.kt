package com.dallmeier.presentation.weather

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dallmeier.myapplication.BR
import com.dallmeier.myapplication.R
import com.dallmeier.myapplication.databinding.FragmentWeathersBinding
import com.dallmeier.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
 class WeathersFragment : BaseFragment<WeatherViewModel, FragmentWeathersBinding>() {
    companion object {
        val FRAGMENT_NAME: String = WeathersFragment::class.java.name
    }
      private var adapter: WeathersAdapter? = null
      private var mBinding: FragmentWeathersBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
        initRecycleView();
    }

    private fun initRecycleView() {
        mBinding?.run {

            adapter = WeathersAdapter()
            if (adapter?.hasObservers() == false) adapter?.setHasStableIds(true)
            rvWeather.adapter = adapter
        }
        with(mViewModel) {
            this?.photosData?.observe(viewLifecycleOwner, Observer {
                adapter?.photoList = it
            })
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchData() //Fetch a list of  from remote or local
    }


    private fun fetchData() {
    mViewModel?.getWeathers(true)
    }

    override fun onProgressBarVisibility(visibility: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_weathers;
    }

    override fun getBindingVariable(): Int {
        return BR._all
    }


}