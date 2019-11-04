package com.muhammed.thasneem.smartnytimeapp.base.baseviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.muhammed.thasneem.smartnytimeapp.view.MainActivity
import com.muhammed.thasneem.smartnytimeapp.viewmodel.BaseFragmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<DataBinding : ViewDataBinding, VM : BaseFragmentViewModel> :
    Fragment() {
    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mActivity: BaseActivity<*, *>
    private lateinit var mRootView: View
    private lateinit var mViewDataBinding: DataBinding

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

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): Class<VM>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mViewDataBinding.lifecycleOwner = this
        mRootView = mViewDataBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    fun getBaseActivity(): BaseActivity<*, *> {
        return mActivity
    }

    fun getViewDataBinding(): DataBinding {
        return mViewDataBinding
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /**
         * Observing progress event
         */

        getViewModelObject().showProgress.observe(this, Observer {
            showLoadingProgress(it)
        })
    }

    /**
     * Enabling disabling progress loading from activity
     */
    protected fun showLoadingProgress(shouldShow: Boolean) {
        (activity as? MainActivity)?.showProgress(shouldShow)
    }
}