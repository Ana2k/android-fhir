package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        binding.detailsId.text = item.id
        binding.detailsAuthorTitle.text = item.author.toString()
        binding.detailsDate.text = item.date.toString()
        binding.sectionTitle0.text = item.section[0].title
        binding.sectionTitle1.text = item.section[1].title
        binding.sectionTitle2.text = item.section[2].title
        binding.sectionTitle3.text = item.section[3].title
        binding.sectionTitle4.text = item.section[4].title

        Log.d("InsideDetsComposition",arguments.ipsPatientDetail.toString())
    }
}