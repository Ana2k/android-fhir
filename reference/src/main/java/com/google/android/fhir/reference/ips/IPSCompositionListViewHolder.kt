package com.google.android.fhir.reference.ips

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.fhir.reference.databinding.IpsCompositionListItemViewBinding

class IPSCompositionListViewHolder(private val binding: IpsCompositionListItemViewBinding):
    RecyclerView.ViewHolder(binding.root){
    companion object{
        fun from(parent: ViewGroup): IPSCompositionListViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = IpsCompositionListItemViewBinding.inflate(inflater,parent,false)
            return IPSCompositionListViewHolder(binding)
        }
    }

    private val titleView = binding.listTitle
    private val descriptionView = binding.listDescription

    //TODO() -- ClickListener in bindTo and as param

    fun bindTo(item: IPSCompositionListViewModel) {
        this.titleView.text = item.title
        this.descriptionView.text = item.date.toString()
    }

}
