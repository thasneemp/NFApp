package com.muhammed.thasneem.smartnytimeapp.webservice

import com.muhammed.thasneem.smartnytimeapp.base.response.ResponseListener
import com.muhammed.thasneem.smartnytimeapp.di.schedulers.SchedulerContract
import com.muhammed.thasneem.smartnytimeapp.models.PopularReviewReponse
import javax.inject.Inject

/**
 * Api Repository for keeping all Api methods
 */

open class MainRepository @Inject constructor(
    private val smartAppApiService: SmartAppApiService,
    schedulerContract: SchedulerContract
) : BaseRepository(schedulerContract) {

    /**
     * Fetching API result from NyTimes.com, as most popular view in JSON format
     * @param sections : all-sections
     * @param period : available period values are 1, 7 and 30, which represents how far back, in
    days, the API returns results for.
     */

    fun getAllPopularViews(
        sections: String,
        period: String,
        responseListener: ResponseListener<PopularReviewReponse>
    ) {
        performRequest(smartAppApiService.getAllPopularViews(sections, period), responseListener)
    }

}