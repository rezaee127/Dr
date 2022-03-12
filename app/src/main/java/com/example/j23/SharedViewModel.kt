package ir.sample.doctorproject2.com.example.j23

import androidx.lifecycle.ViewModel
import ir.sample.doctorproject2.*

class SharedViewModel : ViewModel() {
    var  hospital  = Hospital()


    fun setTestDate(){
        hospital.listOfDoctors.clear()
        hospital.listOfDoctors.add(Doctor(1 , "دکتر زهرا رحیمی" ,  OnlineStatus.Offline ,
            "روانشناسی و مشاوره" ,"09275421452"))
        hospital.listOfDoctors.add(Doctor(2 , "دکتر سما احمدی" , OnlineStatus.Online ,
            "روانشناسی و مشاوره" ,"09274569872"))

        hospital.listOfDoctors.clear()
        hospital.consultancyList = arrayListOf(
            Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
            Consultancy(2 , 60 , 250000, ConsultancyType.Video),
            Consultancy(3 , 90 , 300000, ConsultancyType.Phone))
    }

}