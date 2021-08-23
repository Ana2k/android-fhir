package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.fhir.reference.databinding.IpsCompositionDetailViewBinding

class IPSCompositionDetailsFragment: Fragment() {
    private var _binding: IpsCompositionDetailViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = IpsCompositionDetailViewBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

}