package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.fhir.reference.databinding.IpsCompositionListViewBinding
import org.hl7.fhir.r4.model.Composition
import kotlin.collections.ArrayList

class IPSCompositionListFragment : Fragment() {
    private var _binding: IpsCompositionListViewBinding? = null
    private val binding
    get() = _binding!!

    private lateinit var mCompositionList: ArrayList<Composition>
    private var mRecyclerView: RecyclerView?= null
    private var mListViewModel: IPSCompositionListViewModel?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = IpsCompositionListViewBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = IPSCompositionListViewModel.IPSCompositionViewModelFactory(application)
        val mListViewModel = ViewModelProvider(this,viewModelFactory).get(IPSCompositionListViewModel::class.java)

        mCompositionList = mListViewModel?.mCompositionList?.value as ArrayList<Composition>


        val mRecyclerView = binding.ipsCompositionListRecyclerView
        this.mRecyclerView?.setHasFixedSize(true)

        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mRecyclerView.adapter = IPSCompositionListRecyclerViewAdapter(mCompositionList)

    }


}