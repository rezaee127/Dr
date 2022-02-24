package ir.sample.doctorproject2

import java.util.*
object Hospital{
    val doctorList = arrayListOf<Doctor>()
    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )
    fun setTestDate(){
        doctorList.clear()
        doctorList.add(Doctor(1 , "Dr. sara" ,  OnlineStatus.Offline , "روانشناسی و مشاوره" ))
        doctorList.add(Doctor(2 , "Dr. rostam" , OnlineStatus.Online , "روانشناسی و مشاوره" ))
    }
}

data class Doctor ( val id : Int,
                    val name : String ,
                    var onlineStatus : OnlineStatus ,
                    var field : String ,
                    var imageId : Int? = null
)
enum class OnlineStatus{
    Online, Offline
}
data class Consultancy (val id : Int,
                        val time : Int,
                        val price : Int,
                        val type : ConsultancyType
)

enum class ConsultancyType{
    Phone , Video
}