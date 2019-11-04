package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.muhammed.thasneem.smartnytimeapp.base.framework.SingleLiveEvent
import com.muhammed.thasneem.smartnytimeapp.base.response.ApiResponse
import com.muhammed.thasneem.smartnytimeapp.base.response.ResponseListener
import com.muhammed.thasneem.smartnytimeapp.base.response.ResponseStatus
import com.muhammed.thasneem.smartnytimeapp.models.PopularReviewReponse
import com.muhammed.thasneem.smartnytimeapp.models.ResultsItem
import com.muhammed.thasneem.smartnytimeapp.webservice.MainRepository
import javax.inject.Inject


/**
 * Home fragment manipulation view model
 */
open class HomeFragmentViewModel @Inject constructor(private val repository: MainRepository) :
    BaseFragmentViewModel() {


    /**
     * kept var ofr testing
     */
    var itemClickLiveEvent = SingleLiveEvent<ResultsItem>()

    var listItems = ObservableField<List<ResultsItem>>()

    var emptyLayoutVisibility = ObservableBoolean(false)

    init {

        /**
         * Calling service
         */
        fetchFeeds()
    }

    /**
     * Fetching feeds
     */
    private fun fetchFeeds() {
        repository.getAllPopularViews(
            "all-sections",
            "7",
            object : ResponseListener<PopularReviewReponse> {
                override fun onResponse(result: ApiResponse<PopularReviewReponse>) {
                    if (result.status == ResponseStatus.SUCCESS) {
                        result.data?.results?.let {
                            listItems.set(it)
                        } ?: emptyLayoutVisibility.set(true)
                    } else {
                        emptyLayoutVisibility.set(true)
                    }

                }

                override fun onStart() {
                    showProgress(true)
                    emptyLayoutVisibility.set(false)
                }

                override fun onFinish() {
                    showProgress(false)
                }

            })
    }

    fun onItemTapped(position: Int, resultsItem: ResultsItem) {
        itemClickLiveEvent.value = resultsItem
    }

    /**
     * Refreshing content
     */
    fun loadAgain() {
        fetchFeeds()
    }
}