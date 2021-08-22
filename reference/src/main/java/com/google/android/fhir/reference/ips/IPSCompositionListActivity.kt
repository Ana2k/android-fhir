package com.google.android.fhir.reference.ips

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.fhir.reference.databinding.ActivityIpsBinding

class IPSCompositionListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIpsBinding.inflate(layoutInflater)
        val view = binding.root
        Log.d("IPSACTIVITY","MESsage")
        setContentView(view)
    }
}