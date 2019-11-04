package com.muhammed.thasneem.smartnytimeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.muhammed.thasneem.smartnytimeapp.databinding.PopularViewsRowBinding
import com.muhammed.thasneem.smartnytimeapp.models.ResultsItem
import com.muhammed.thasneem.smartnytimeapp.view.listeners.OnItemTapListener

/**
 * Responsible for populating Result from api response as List
 */
class PopularViewAdapter : RecyclerView.Adapter<PopularViewAdapter.PopularViewBinder>(), Filterable {
    override fun getFilter(): Filter {
        return ItemFilter()
    }

    var onItemTapListener: OnItemTapListener? = null
    private var listItems = ArrayList<ResultsItem>()
    private var filteredItem = ArrayList<ResultsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewBinder {
        val popularViewsRowBinding = PopularViewsRowBinding.inflate(LayoutInflater.from(parent.context))
        return PopularViewBinder(popularViewsRowBinding)
    }

    override fun getItemCount(): Int {
        return filteredItem.size
    }

    override fun onBindViewHolder(holder: PopularViewBinder, position: Int) {
        holder.bind(filteredItem[position], position)
    }


    inner class PopularViewBinder constructor(private val popularViewsRowBinding: PopularViewsRowBinding) :
        RecyclerView.ViewHolder(popularViewsRowBinding.root) {
        fun bind(resultsItem: ResultsItem, position: Int) {
            popularViewsRowBinding.item = resultsItem
            popularViewsRowBinding.position = position
            popularViewsRowBinding.onItemTapListener = onItemTapListener
            popularViewsRowBinding.executePendingBindings()
        }

    }

    fun setItems(listItems: List<ResultsItem>) {
        this.listItems.clear()
        this.filteredItem.clear()
        this.listItems.addAll(listItems)
        this.filteredItem.addAll(listItems)
        notifyDataSetChanged()
    }

    fun setItemTapListener(onItemTapListener: OnItemTapListener?) {
        this.onItemTapListener = onItemTapListener
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterString = constraint.toString().toLowerCase()
            val count = listItems.size

            val results = FilterResults()
            if (filterString.isEmpty()) {
                filteredItem = listItems
            } else {
                val nList = ArrayList<ResultsItem>(count)
                for (i in 0 until count) {
                    if ((listItems[i].title ?: "").toLowerCase().contains(filterString)) {
                        nList.add(listItems[i])
                    }
                }
                filteredItem = nList
            }
            results.values = filteredItem
            results.count = filteredItem.size
            return results

        }

        override fun publishResults(p0: CharSequence?, results: FilterResults?) {
            filteredItem = (results?.values as ArrayList<ResultsItem>)
            notifyDataSetChanged()
        }

    }
}