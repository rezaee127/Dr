package ir.sample.doctorproject2.com.example.j23.Model

data class  Doctor(
    val id: Int,
    val name: String,
    var onlineStatus: OnlineStatus,
    var expertise: String,
    var phone: String,
    var imageId: Int? = null
)

enum class OnlineStatus {
    Online, Offline
}
