package com.muhammed.thasneem.smartnytimeapp.webservice

import com.muhammed.thasneem.smartnytimeapp.models.PopularReviewReponse
import com.muhammed.thasneem.smartnytimeapp.webservice.utils.URLConstants
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Api Listing interface
 */
interface SmartAppApiService {


    @GET(URLConstants.BASE_PATH)
    fun getAllPopularViews(@Path(URLConstants.KEY_SECTION) sections: String, @Path(URLConstants.KEY_PERIOD) period: String):
            Observable<PopularReviewReponse>
}