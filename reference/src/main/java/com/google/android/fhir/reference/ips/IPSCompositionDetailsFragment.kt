package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.fhir.reference.PatientDetailsFragmentArgs
import com.google.android.fhir.reference.databinding.IpsCompositionDetailViewBinding
import org.hl7.fhir.r4.model.Composition

class IPSCompositionDetailsFragment: Fragment() {
    private var _binding: IpsCompositionDetailViewBinding? = null
    private val binding get() = _binding!!
    private val args: PatientDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = IpsCompositionDetailViewBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = IPSCompositionDetailsFragmentArgs.fromBundle(arguments as Bundle)
        val item = arguments.ipsPatientDetail as Composition
        //extract the argument files.
        //make a textview. text
        //then show that in those
        binding.detailsId.text = "Id"
        binding.detailsAuthorTitle.text = "author"
        binding.detailsDate.text = "02/03/2021"
        binding.detailsAddress.text = "address"
        binding.detailsPatientName.text = "name : Ana"
        binding.detailsPatientDob.text = "dob: 2nd march"
        binding.detailsDose.text = "dose"
        binding.detailsResourceId.text = "Resource ID 88"

        Log.d("InsideDetsComposition",arguments.ipsPatientDetail.toString())
    }
}