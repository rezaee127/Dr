package ir.sample.doctorproject2.com.example.j23.Model


class  Hospital {
    var listOfDoctors = arrayListOf<Doctor>()
    var consultancyList = arrayListOf<Consultancy>()


    fun setTestDate() {
        listOfDoctors.clear()
        consultancyList.clear()

        listOfDoctors.add(
            Doctor(
                1,
                "دکتر زهرا رحیمی",
                OnlineStatus.Offline,
                "روانشناسی و مشاوره",
                "09275421452"
            )
        )
        listOfDoctors.add(
            Doctor(
                2,
                "دکتر سما احمدی",
                OnlineStatus.Online,
                "روانشناسی و مشاوره",
                "09274569872"
            )
        )

        consultancyList = arrayListOf(
            Consultancy(1, 30, 100000, ConsultancyType.Phone),
            Consultancy(2, 60, 250000, ConsultancyType.Video),
            Consultancy(3, 90, 300000, ConsultancyType.Phone))
    }

    fun getDoctor(id: Int): Doctor? {
        for (doctor in listOfDoctors)
            if (doctor.id == id)
                return doctor

        return null
    }

}
