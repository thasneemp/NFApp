package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.databinding.ObservableField
import com.muhammed.thasneem.smartnytimeapp.base.framework.SingleLiveEvent
import javax.inject.Inject


/**
 * Item details manipulating View Model
 */
open class ItemDetailsFragmentViewModel @Inject constructor() : BaseFragmentViewModel() {
    var urlForLoadingDetails = ObservableField<String>()
    fun webLoadingStatus(isStarted: Boolean) {
        showProgress(isStarted)
    }
}