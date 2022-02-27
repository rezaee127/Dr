package com.example.j23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.j23.databinding.Activity1Binding
import ir.sample.doctorproject2.Hospital

class Activity1 : AppCompatActivity() {
    lateinit var binding: Activity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        Hospital.setTestDate()
        val listOfButtons= arrayListOf(binding.button1,binding.button2)
        for (i in listOfButtons.indices) {
            listOfButtons[i].text = Hospital.listOfDoctors[i].name

            listOfButtons[i].setOnClickListener {
                goToDoctorActivity(Hospital.listOfDoctors[i].id)
            }
        }

    }


    private fun goToDoctorActivity(id: Int) {
        val intent = Intent(this, DoctorActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}