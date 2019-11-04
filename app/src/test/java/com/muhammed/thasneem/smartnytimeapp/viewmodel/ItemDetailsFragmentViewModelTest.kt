package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.databinding.ObservableField
import com.google.gson.Gson
import com.muhammed.thasneem.smartnytimeapp.TestUtils
import com.muhammed.thasneem.smartnytimeapp.base.framework.SingleLiveEvent
import com.muhammed.thasneem.smartnytimeapp.models.PopularReviewReponse
import com.muhammed.thasneem.smartnytimeapp.models.ResultsItem
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations


@RunWith(
    JUnit4::class
)
class ItemDetailsFragmentViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var homeFragmentViewModel: ItemDetailsFragmentViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        homeFragmentViewModel.showProgress = SingleLiveEvent()
    }


    @Test
    fun test_URL_Value() {
        /**
         * Check is null
         */
        Assert.assertNull("Should null", homeFragmentViewModel.urlForLoadingDetails)

        /**
         * Assign object
         */

        homeFragmentViewModel.urlForLoadingDetails = ObservableField()

        /**
         * Check is null
         */
        Assert.assertNotNull("Should not null", homeFragmentViewModel.urlForLoadingDetails)


        /**
         * Assign value
         */

        homeFragmentViewModel.urlForLoadingDetails.set(getDummyList()?.get(0)?.url)

        /**
         * checking the value
         */
        Assert.assertNotNull("Should not null", homeFragmentViewModel.urlForLoadingDetails.get())


        /**
         * Update web loading status
         */

        homeFragmentViewModel.webLoadingStatus(true)

        /**
         * checking the value
         */
        Assert.assertTrue("Should true", homeFragmentViewModel.showProgress.value ?: false)


    }


    private fun getDummyList(): List<ResultsItem>? {
        val jsonObject = TestUtils.getJsonObject()
        val response = Gson().fromJson(jsonObject, PopularReviewReponse::class.java)
        return response.results
    }
}