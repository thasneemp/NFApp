package com.muhammed.thasneem.smartnytimeapp.base.response

interface ResponseListener<T> {
    fun onStart() {

    }

    fun onFinish() {

    }

    fun onResponse(result: ApiResponse<T>)
}