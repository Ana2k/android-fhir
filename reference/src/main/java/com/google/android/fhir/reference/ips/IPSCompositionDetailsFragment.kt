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
        //extract the argument files.
        //make a textview. text
        //then show that in those
        //from android docs:-
        val textView = binding.detailsTextView
        val arguments = IPSCompositionDetailsFragmentArgs.fromBundle(requireArguments())
        Log.d("InsideDetsComposition",arguments.ipsPatientDetail.toString())
    }
}