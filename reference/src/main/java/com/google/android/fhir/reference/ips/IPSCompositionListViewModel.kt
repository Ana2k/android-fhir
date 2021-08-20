package com.google.android.fhir.reference.ips

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import org.hl7.fhir.r4.model.Composition
import java.util.Date
import kotlin.collections.ArrayList

class IPSCompositionListViewModel(application: Application): AndroidViewModel(application){

    private var _mCompositionList = MutableLiveData<ArrayList<Composition>>()
    val mCompositionList: LiveData<ArrayList<Composition>> get() = _mCompositionList
    init {
        createCompositionList()
    }

    private fun createCompositionList() {
        var obj = Composition()
        obj.setTitle("OBJECT1")
        obj.setDate(Date())

        var obj2 = Composition()
        obj2.setTitle("OBJECT2")
        obj2.setDate(Date())

        var sample = ArrayList<Composition>()

        sample.add(obj)
        sample.add(obj2)
        _mCompositionList.value = sample
    }

    class IPSCompositionViewModelFactory(private val application: Application):
    ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom((IPSCompositionListViewModel::class.java))){
                return IPSCompositionListViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }


    }

}
