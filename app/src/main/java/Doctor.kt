package ir.sample.doctorproject2

/*object Hospital{
    val listOfDoctors = arrayListOf<Doctor>()
    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )
    fun setTestDate(){
        listOfDoctors.clear()
        listOfDoctors.add(Doctor(1 , "دکتر زهرا رحیمی" ,  OnlineStatus.Offline , "روانشناسی و مشاوره" ,"09275421452"))
        listOfDoctors.add(Doctor(2 , "دکتر سما احمدی" , OnlineStatus.Online , "روانشناسی و مشاوره" ,"09274569872"))
    }

    fun getDoctor(id:Int):Doctor?{
        for (doctor in listOfDoctors)
            if (doctor.id == id)
                return doctor

        return  null
    }
}

data class Doctor ( val id : Int,
                    val name : String ,
                    var onlineStatus : OnlineStatus ,
                    var expertise : String ,
                    var phone: String,
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

 */