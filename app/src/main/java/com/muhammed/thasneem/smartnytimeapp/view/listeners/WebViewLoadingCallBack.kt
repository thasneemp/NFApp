package com.muhammed.thasneem.smartnytimeapp.view.listeners


/**
 * WebView loading status listener this will trigger when
 * page start and page finish with boolean value {true or false}
 */
interface WebViewLoadingCallBack {

    fun onPageLoadingStatus(isStarted: Boolean)
}