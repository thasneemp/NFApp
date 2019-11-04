package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import javax.inject.Inject


/**
 * Responsible for keeping all activity related manipulations
 */
class MainActivityViewModel @Inject constructor() : ViewModel() {

    val progressVisibility = ObservableBoolean(false)
}