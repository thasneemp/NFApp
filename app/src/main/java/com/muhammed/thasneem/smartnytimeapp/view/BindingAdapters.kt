package com.muhammed.thasneem.smartnytimeapp.view

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.muhammed.thasneem.smartnytimeapp.adapters.PopularViewAdapter
import com.muhammed.thasneem.smartnytimeapp.di.modules.GlideApp
import com.muhammed.thasneem.smartnytimeapp.models.ResultsItem
import com.muhammed.thasneem.smartnytimeapp.view.listeners.OnItemTapListener
import com.muhammed.thasneem.smartnytimeapp.view.listeners.WebViewLoadingCallBack


/**
 * Custom bindings for UI Data binding
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("listItems", "onTapListener", requireAll = false)
    fun setPopularListAdapter(
        view: RecyclerView,
        listItems: List<ResultsItem>?,
        onItemTapListener: OnItemTapListener?
    ) {
        listItems?.let {
            val popularViewAdapter: PopularViewAdapter = if (view.adapter != null) {
                (view.adapter as PopularViewAdapter)
            } else {
                val adapter = PopularViewAdapter()
                view.adapter = adapter
                adapter
            }
            popularViewAdapter.setItems(listItems)
            popularViewAdapter.setItemTapListener(onItemTapListener)
        }
    }

    @JvmStatic
    @BindingAdapter("imgUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
            GlideApp.with(imageView.context).applyDefaultRequestOptions(RequestOptions().circleCrop()).load(imageUrl)
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("webUrl", "loadingStatusCallBack", requireAll = false)
    fun setWebUrl(view: WebView, webUrl: String?, loadingStatusCallBack: WebViewLoadingCallBack?) {
        webUrl?.let {
            view.loadUrl(it)

            view.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    loadingStatusCallBack?.onPageLoadingStatus(true)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    loadingStatusCallBack?.onPageLoadingStatus(false)
                }
            }
        }
    }
}