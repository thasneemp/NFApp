package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.muhammed.thasneem.smartnytimeapp.base.framework.SingleLiveEvent

/**
 * File Description
 * ------------------
 * Author : thasneem
 * Email : thasneem@farabi.ae
 * Date : 9/23/2019
 * Project : NewsFeed
 * Company : Farabi Technology
 */
open class BaseFragmentViewModel : ViewModel() {
    var showProgress = SingleLiveEvent<Boolean>()

    /**
     * For show or hide progress bar
     */
    fun showProgress(shouldShow: Boolean) {
        showProgress.value = shouldShow
    }
}