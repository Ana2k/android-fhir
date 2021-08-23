package com.google.android.fhir.reference.ips

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.hl7.fhir.r4.model.Composition

class IPSCompositionListRecyclerViewAdapter(private val onIPSItemClicked: (Composition)->Unit) :
    ListAdapter<Composition, IPSCompositionListViewHolder>(IPSCompositionListDiffCallBack()) {
    //expects an item here. so we need to do some item stuff with viewmodel

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): IPSCompositionListViewHolder {
        Log.d("IPSADAPTER","inside onCreateViewHolder")
        return IPSCompositionListViewHolder.from(parent)
    }

    class IPSCompositionListDiffCallBack :
        DiffUtil.ItemCallback<Composition>(){
        override fun areItemsTheSame(oldItem: Composition, newItem: Composition): Boolean{
            Log.d("IPSADAPTER",oldItem.toString()+"oldItem"+" newITem"+newItem.toString())
            return  oldItem.id == newItem.id
        }
            //oldItem--- iCviewModel.composition object?
            //same for --- icViewModel.composition obj?

        override fun areContentsTheSame(oldItem: Composition, newItem: Composition): Boolean {
            Log.d("IPSADAPTER",oldItem.toString()+"oldItem"+" newITem"+newItem.toString())
           return oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(
        holder: IPSCompositionListViewHolder,
        position: Int,
    ) {
        val item = currentList[position]
        Log.d("IPSADAPTER",item.toString())
        holder.bindTo(item,onIPSItemClicked)

    }
}
