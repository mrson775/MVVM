package com.dallmeier.presentation.nfc

import android.os.Bundle
import android.view.View
import com.dallmeier.myapplication.BR
import com.dallmeier.myapplication.R
import com.dallmeier.myapplication.databinding.FragmentNfcBinding
import com.dallmeier.myapplication.databinding.FragmentWeathersBinding
import com.dallmeier.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
 class NfcFragment : BaseFragment<NfcViewModel, FragmentNfcBinding>() {
    companion object {
        val FRAGMENT_NAME: String = NfcFragment::class.java.name
    }
      private var mBinding: FragmentNfcBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchData() //Fetch a list of  from remote or local
    }


    private fun fetchData() {
        activity?.let { mViewModel?.readFromIntent(it.intent) }
    }

    override fun onProgressBarVisibility(visibility: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_nfc;
    }

    override fun getBindingVariable(): Int {
        return BR._all
    }

}