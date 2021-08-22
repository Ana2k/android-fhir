package com.google.android.fhir.reference.ips

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.fhir.reference.databinding.IpsCompositionListItemViewBinding
import org.hl7.fhir.r4.model.Composition

class IPSCompositionListViewHolder(val binding: IpsCompositionListItemViewBinding):
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

    fun bindTo(ipsItem: Composition, onIPSItemClicked: (Composition) -> Unit) {
        this.titleView.text = ipsItem.title
        this.descriptionView.text = ipsItem.date.toString()
        this.itemView.setOnClickListener { onIPSItemClicked(ipsItem) }


    }

}
