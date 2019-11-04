package com.muhammed.thasneem.smartnytimeapp.base.response

import android.content.Context
import android.util.MalformedJsonException
import com.muhammed.thasneem.smartnytimeapp.R
import com.muhammed.thasneem.smartnytimeapp.SmartNYTimesApplication
import java.io.IOException
import java.net.SocketTimeoutException


/****
 *
 * Api response molder
 *****/

data class ApiResponse<out T>(
    val status: Int,
    val data: T?,
    val error: Throwable?
) {


    var errorCode: String = ""
    var errorDescription: String = ""

    init {
        error?.let {
            val context: Context = SmartNYTimesApplication.applicationContext()
            this.errorDescription = context.getString(R.string.unknownError)
            when (it) {
                is SocketTimeoutException -> {
                    this.errorDescription = context.getString(R.string.requestTimeOutError)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }
                is MalformedJsonException -> {
                    this.errorDescription = context.getString(R.string.responseMalformedJson)
                    this.errorCode = context.getString(R.string.errorCodeMalformedJson)
                }
                is IOException -> {
                    this.errorDescription =
                        context.getString(R.string.seems_network_not_connected_please_try_again)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }


            }
        }
    }

}

