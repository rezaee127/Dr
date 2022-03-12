package ir.sample.doctorproject2.com.example.j23

import androidx.lifecycle.ViewModel
import ir.sample.doctorproject2.com.example.j23.Model.Consultancy
import ir.sample.doctorproject2.com.example.j23.Model.Hospital

class DoctorActivityViewModel : ViewModel(){
    val hospital=Hospital()
    var listOfConsultancy=arrayListOf<Consultancy>()

    init {

        hospital.setTestDate()
        listOfConsultancy=hospital.consultancyList
    }


}
