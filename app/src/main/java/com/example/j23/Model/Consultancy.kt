package ir.sample.doctorproject2.com.example.j23.Model

data class Consultancy(
    val id: Int,
    val time: Int,
    val price: Int,
    val type: ConsultancyType
){

}

enum class ConsultancyType {
    Phone, Video


}