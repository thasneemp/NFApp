package com.muhammed.thasneem.smartnytimeapp.view.fragments

import android.os.Bundle
import android.view.*
import com.muhammed.thasneem.smartnytimeapp.BR
import com.muhammed.thasneem.smartnytimeapp.R
import com.muhammed.thasneem.smartnytimeapp.base.baseviews.BaseFragment
import com.muhammed.thasneem.smartnytimeapp.databinding.ItemDetailsFragmentBinding
import com.muhammed.thasneem.smartnytimeapp.view.MainActivity
import com.muhammed.thasneem.smartnytimeapp.viewmodel.ItemDetailsFragmentViewModel

/**
 * Fragment for Details rendering
 */
class ItemDetailsFragment :
    BaseFragment<ItemDetailsFragmentBinding, ItemDetailsFragmentViewModel>() {
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.item_details_fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Enabling toolbar back

        (activity as? MainActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? MainActivity)?.supportActionBar?.title = arguments?.let {
            it[TITLE_EXTRA] as String
        } ?: getString(R.string.app_name)

        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun getViewModel(): Class<ItemDetailsFragmentViewModel> {
        return ItemDetailsFragmentViewModel::class.java
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val url = it[URL_EXTRA] as String
            getViewModelObject().urlForLoadingDetails.set(url)
        }
    }


    companion object {

        const val URL_EXTRA = "url_extra"
        const val TITLE_EXTRA = "title_extra"

        fun getInstance(): ItemDetailsFragment {
            return ItemDetailsFragment()
        }
    }

    override fun onPause() {
        super.onPause()
        showLoadingProgress(false)

        //resetAll
        resetToolBar()
    }


    /**
     * Resetting all values for home screen retention
     */
    private fun resetToolBar() {
        (activity as? MainActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as? MainActivity)?.supportActionBar?.title = getString(R.string.app_name)
        setHasOptionsMenu(false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menus, menu)
        val searchItem = menu.findItem(R.id.action_search)
        searchItem.isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}