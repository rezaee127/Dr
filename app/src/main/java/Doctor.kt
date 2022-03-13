package ir.sample.doctorproject2


class Hospital{

    val listOfDoctors = arrayListOf<Doctor>()
    var consultancyList = arrayListOf<Consultancy>()


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

