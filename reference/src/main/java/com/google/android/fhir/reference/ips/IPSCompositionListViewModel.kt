package com.google.android.fhir.reference.ips

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.fhir.FhirEngine
import org.hl7.fhir.r4.model.Composition
import java.util.*
import kotlin.collections.ArrayList

class IPSCompositionListViewModel(application: Application, private val fhirEngine: FhirEngine) :
    ViewModel() {

    private var _mCompositionList = MutableLiveData<ArrayList<Composition>>()
    val mCompositionList: LiveData<ArrayList<Composition>> get() = _mCompositionList

    init {
        createCompositionList()
        Log.d("IPSVIEWMODEL", "inside init Viewmodel")
// fetchResults()
    }

    private fun createCompositionList() {
        var obj = Composition()
        obj.setTitle("OBJECT1")
        obj.setDate(Date())

        val t1 = Composition.SectionComponent()
        t1.title = "Active Problems"
        val t2 = Composition.SectionComponent()
        t2.title = "Medication"
        val t3 = Composition.SectionComponent()
        t3.title = "Allergies and Intolerances"
        val t4 = Composition.SectionComponent()
        t4.title = "History of Past Illness"
        val t5 = Composition.SectionComponent()
        t5.title = "Plan of Treatment"

        val list: List<Composition.SectionComponent> = mutableListOf(t1, t2, t3, t4, t5)

        obj.setSection(list)

        var obj2 = Composition()
        obj2.setTitle("OBJECT2")
        obj2.setDate(Date())
        obj2.setSection(list)

        var obj3 = Composition()
        obj3.setTitle("OBJECT2")
        obj3.setDate(Date())
        obj3.setSection(list)

        var obj4 = Composition()
        obj4.setTitle("OBJECT2")
        obj4.setDate(Date())
        obj4.setSection(list)

        var obj5 = Composition()
        obj5.setTitle("OBJECT2")
        obj5.setDate(Date())
        obj5.setSection(list)

        var obj6 = Composition()
        obj6.setTitle("OBJECT2")
        obj6.setDate(Date())
        obj6.setSection(list)

        var obj7 = Composition()
        obj7.setTitle("OBJECT2")
        obj7.setDate(Date())
        obj7.setSection(list)

        var obj8 = Composition()
        obj8.setTitle("OBJECT2")
        obj8.setDate(Date())
        obj8.setSection(list)

        var obj9 = Composition()
        obj9.setTitle("OBJECT2")
        obj9.setDate(Date())
        obj9.setSection(list)

        var obj10 = Composition()
        obj10.setTitle("OBJECT2")
        obj10.setDate(Date())
        obj10.setSection(list)


        var obj11 = Composition()
        obj11.setTitle("OBJECT2")
        obj11.setDate(Date())
        obj11.setSection(list)

        var obj12 = Composition()
        obj12.setTitle("OBJECT2")
        obj12.setDate(Date())
        obj12.setSection(list)

        var obj13 = Composition()
        obj13.setTitle("OBJECT2")
        obj13.setDate(Date())
        obj13.setSection(list)

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
    }

// private fun fetchResults() {
// viewModelScope.launch {
// getCompositionResults()
// }
// }
//
// private suspend fun getCompositionResults() {
////// val patients: MutableList<PatientListViewModel.PatientItem> = mutableListOf()
// val items: MutableList<Composition> = mutableListOf()
////
//// fhirEngine
//// .search<Composition> {
//// count = 100
//// from = 0
//// }
//// .take(MAX_RESOURCE_COUNT)
//// .let { items.addAll(it) }
//// _mCompositionList.value=items
// }

    class IPSCompositionViewModelFactory(
        private val application: Application,
        private val fhirEngine: FhirEngine
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom((IPSCompositionListViewModel::class.java))) {
                Log.d("IPSVIEWMODELFACTORY", "inside init Viewmodelfocatory")
                return IPSCompositionListViewModel(application, fhirEngine) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }

}