package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mListViewModel: IPSCompositionListViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = IpsCompositionListViewBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("IPSFRAG","onCreateView--Fragment")


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = IPSCompositionListViewModel.IPSCompositionViewModelFactory(application)
        mListViewModel = ViewModelProvider(this,viewModelFactory).get(IPSCompositionListViewModel::class.java)

        mCompositionList = mListViewModel.mCompositionList.value as ArrayList<Composition>


        Log.d("IPSFRAG list", mCompositionList.toString())

        mRecyclerView = binding.ipsCompositionListRecyclerView
        this.mRecyclerView?.setHasFixedSize(true)

        mRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        Log.d("IPSFRAG layout manager", mRecyclerView.layoutManager.toString())

        val adapter = IPSCompositionListRecyclerViewAdapter()

        mRecyclerView.adapter =adapter

        mListViewModel.mCompositionList.observe(viewLifecycleOwner, Observer {
            Log.d("IPSFRAG","Observer--Fragment{}")
            adapter.submitList(it)
            Log.d("IPSFRAG it",it.toString())
        })

        Log.d("IPSFRAG Viewmodel", mListViewModel.toString())
        Log.d("IPSFRAG adapter",adapter.toString())


    }


}