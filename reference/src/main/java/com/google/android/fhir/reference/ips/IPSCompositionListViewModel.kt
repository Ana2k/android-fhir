package com.google.android.fhir.reference.ips

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import org.hl7.fhir.r4.model.Composition
import java.util.Date
import kotlin.collections.ArrayList

class IPSCompositionListViewModel(application: Application): ViewModel(){

    private var _mCompositionList = MutableLiveData<ArrayList<Composition>>()
    val mCompositionList: LiveData<ArrayList<Composition>> get() = _mCompositionList
    init {
        createCompositionList()
        Log.d("IPSVIEWMODEL","inside init Viewmodel")
    }

    private fun createCompositionList() {
        var obj = Composition()
        obj.setTitle("OBJECT1")
        obj.setDate(Date())

        var obj2 = Composition()
        obj2.setTitle("OBJECT2")
        obj2.setDate(Date())

        var obj3 = Composition()
        obj3.setTitle("OBJECT2")
        obj3.setDate(Date())

        var obj4 = Composition()
        obj4.setTitle("OBJECT2")
        obj4.setDate(Date())

        var obj5 = Composition()
        obj5.setTitle("OBJECT2")
        obj5.setDate(Date())

        var obj6 = Composition()
        obj6.setTitle("OBJECT2")
        obj6.setDate(Date())

        var obj7 = Composition()
        obj7.setTitle("OBJECT2")
        obj7.setDate(Date())

        var obj8 = Composition()
        obj8.setTitle("OBJECT2")
        obj8.setDate(Date())

        var obj9 = Composition()
        obj9.setTitle("OBJECT2")
        obj9.setDate(Date())

        var obj10 = Composition()
        obj10.setTitle("OBJECT2")
        obj10.setDate(Date())


        var obj11 = Composition()
        obj11.setTitle("OBJECT2")
        obj11.setDate(Date())

        var obj12 = Composition()
        obj12.setTitle("OBJECT2")
        obj12.setDate(Date())

        var obj13 = Composition()
        obj13.setTitle("OBJECT2")
        obj13.setDate(Date())

        var sample = ArrayList<Composition>()

        sample.add(obj)
        sample.add(obj2)
        sample.add(obj3)
        sample.add(obj4)
        sample.add(obj5)
        sample.add(obj6)
        sample.add(obj7)
        sample.add(obj8)
        sample.add(obj9)
        sample.add(obj10)
        sample.add(obj11)
        sample.add(obj12)
        sample.add(obj13)

        _mCompositionList.value = sample

        Log.d("IPSVIEWMODEL","inside createdCompositionList Viewmodel -- obj creation called")

    }

    class IPSCompositionViewModelFactory(private val application: Application):
    ViewModelProvider.Factory
    {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom((IPSCompositionListViewModel::class.java))){
                Log.d("IPSVIEWMODELFACTORY","inside init Viewmodelfocatory")
                return IPSCompositionListViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }


    }

}
