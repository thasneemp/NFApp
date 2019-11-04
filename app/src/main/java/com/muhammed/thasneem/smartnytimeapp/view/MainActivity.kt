package com.muhammed.thasneem.smartnytimeapp.view

import android.os.Bundle
import com.muhammed.thasneem.smartnytimeapp.BR
import com.muhammed.thasneem.smartnytimeapp.R
import com.muhammed.thasneem.smartnytimeapp.base.baseviews.BaseActivity
import com.muhammed.thasneem.smartnytimeapp.databinding.ActivityMainBinding
import com.muhammed.thasneem.smartnytimeapp.view.fragments.HomeFragment
import com.muhammed.thasneem.smartnytimeapp.viewmodel.MainActivityViewModel

/**
 * Keeping fragment communication and main home for the app
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): Class<MainActivityViewModel> {
        return MainActivityViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(mViewDataBinding.toolbar.toolbar)
        //Pushing Home Fragment
        pushHomeFragment()
    }

    private fun pushHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.homeContainerFrameLayout, HomeFragment.getInstance())
            .commit()
    }


    /**
     * data Loading Progress bar show hide function
     */
    fun showProgress(shouldShow: Boolean) {
        getViewModelObject().progressVisibility.set(shouldShow)
    }

}
