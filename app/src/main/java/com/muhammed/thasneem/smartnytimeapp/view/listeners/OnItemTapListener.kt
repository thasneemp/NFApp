package com.muhammed.thasneem.smartnytimeapp.view.listeners

import com.muhammed.thasneem.smartnytimeapp.models.ResultsItem


/**
 * Item tap listener for recycler view item click
 */
interface OnItemTapListener {
    fun onItemTapped(posi: Int, resultsItem: ResultsItem)
}