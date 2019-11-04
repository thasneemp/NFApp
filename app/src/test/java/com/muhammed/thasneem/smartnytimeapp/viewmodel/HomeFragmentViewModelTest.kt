package com.muhammed.thasneem.smartnytimeapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.databinding.ObservableBoolean
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
class HomeFragmentViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        homeFragmentViewModel.emptyLayoutVisibility = ObservableBoolean()
    }


    @Test
    fun testEmpty_Layout_Function_() {


        /**
         * Check whether the emptylayout param is null
         */
        Assert.assertNotNull("should not null", homeFragmentViewModel.emptyLayoutVisibility)

        /**
         * Set values
         */
        homeFragmentViewModel.emptyLayoutVisibility.set(true)

        Assert.assertEquals(
            "Expected true",
            true,
            homeFragmentViewModel.emptyLayoutVisibility.get()
        )

    }

    @Test
    fun test_List_Iem_Manipulation() {
        /**
         * Check is null
         */
        Assert.assertNull("Should null", homeFragmentViewModel.listItems)

        /***
         * Initialize object object
         */

        homeFragmentViewModel.listItems = ObservableField()

        Assert.assertNotNull("Should not null", homeFragmentViewModel.listItems)


        /**
         * add items to the list
         */

        homeFragmentViewModel.listItems.set(getDummyList())


        /**
         * Check list empty or not
         */
        Assert.assertNotNull("not null", homeFragmentViewModel.listItems.get())


        /**
         * Checking array size
         */

        Assert.assertTrue("not null", homeFragmentViewModel.listItems.get()?.isNotEmpty() == true)


    }

    @Test
    fun test_Action_Tapped() {
        /**
         * Check is null
         */
        Assert.assertNull("Should null", homeFragmentViewModel.itemClickLiveEvent)


        /***
         * Initialize object object
         */

        homeFragmentViewModel.listItems = ObservableField()

        Assert.assertNotNull("Should not null", homeFragmentViewModel.listItems)

        /**
         * add items to the list
         */

        homeFragmentViewModel.listItems.set(getDummyList())
        /**
         * Initialize object
         */
        homeFragmentViewModel.itemClickLiveEvent = SingleLiveEvent()


        Assert.assertNotNull("Should not null", homeFragmentViewModel.itemClickLiveEvent)


        homeFragmentViewModel.onItemTapped(0, homeFragmentViewModel.listItems.get()!![0])

        /**
         * Check whether the live event has value
         */
        Assert.assertNotNull("Should not null", homeFragmentViewModel.itemClickLiveEvent.value)

    }

    private fun getDummyList(): List<ResultsItem>? {
        val jsonObject = TestUtils.getJsonObject()
        val response = Gson().fromJson(jsonObject, PopularReviewReponse::class.java)
        return response.results
    }
}