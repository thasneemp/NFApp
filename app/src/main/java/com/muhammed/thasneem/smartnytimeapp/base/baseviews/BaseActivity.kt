package com.muhammed.thasneem.smartnytimeapp.base.baseviews

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<DataBinding : ViewDataBinding, VM : ViewModel> : AppCompatActivity(),
    HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>
    private var mActivity: BaseActivity<*, *>? = null
     lateinit var mViewDataBinding: DataBinding

    fun getViewModelObject(): VM {
        return mViewModel
    }

    private lateinit var mViewModel: VM

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): Class<VM>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentAndroidInjector
    }
}