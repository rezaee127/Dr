package ir.sample.doctorproject2.com.example.j23

import androidx.lifecycle.ViewModel
import ir.sample.doctorproject2.com.example.j23.Model.Doctor
import ir.sample.doctorproject2.com.example.j23.Model.Hospital


class Activity1VewModel: ViewModel() {
    var listOfDoctor=ArrayList<Doctor>()


    init{
        val hospital=Hospital()
        hospital.setTestDate()
        listOfDoctor=hospital.listOfDoctors
    }


}