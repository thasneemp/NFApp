package com.muhammed.thasneem.smartnytimeapp.view.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.muhammed.thasneem.smartnytimeapp.BR
import com.muhammed.thasneem.smartnytimeapp.R
import com.muhammed.thasneem.smartnytimeapp.adapters.PopularViewAdapter
import com.muhammed.thasneem.smartnytimeapp.base.baseviews.BaseFragment
import com.muhammed.thasneem.smartnytimeapp.databinding.HomeFragmentBinding
import com.muhammed.thasneem.smartnytimeapp.viewmodel.HomeFragmentViewModel


/**
 * Home Fragment for UI rendering
 */

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeFragmentViewModel>(),
    SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            (getViewDataBinding().itemRv.adapter as? PopularViewAdapter).let {
                it?.filter?.filter(query)
            }
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let {
            (getViewDataBinding().itemRv.adapter as? PopularViewAdapter).let {
                it?.filter?.filter(newText)
            }
        }
        return true
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun getViewModel(): Class<HomeFragmentViewModel> {
        return HomeFragmentViewModel::class.java
    }


    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menus, menu)
        val searchItem = menu.findItem(R.id.action_search)
        searchItem.isVisible = true
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Observing item click
        getViewModelObject().itemClickLiveEvent.observe(this, Observer {

            //Adding details to ItemDetailsFragment

            val bundle = Bundle()
            bundle.putString(ItemDetailsFragment.URL_EXTRA, it.url)
            bundle.putString(ItemDetailsFragment.TITLE_EXTRA, it.title)
            val instance = ItemDetailsFragment.getInstance()
            instance.arguments = bundle
            //Pushing Details screen fragment
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(ItemDetailsFragment::class.java.canonicalName)
                ?.add(R.id.homeContainerFrameLayout, instance)?.commit()

        })
    }
}