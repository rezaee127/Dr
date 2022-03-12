package ir.sample.doctorproject2.com.example.j23

import androidx.lifecycle.ViewModel
import ir.sample.doctorproject2.com.example.j23.Model.Doctor
import ir.sample.doctorproject2.com.example.j23.Model.Hospital

class ConsultActivityViewModel:ViewModel() {
    var hospital1=Hospital()
    var listOfDoctor= arrayListOf<Doctor>()


    init {

        hospital1.setTestDate()
        listOfDoctor=hospital1.listOfDoctors

    }


}
