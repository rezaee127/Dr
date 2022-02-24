package com.example.j23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.j23.databinding.ActivityDoctorBinding


class DoctorActivity : AppCompatActivity() {
    lateinit var binding:ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_doctor)
        binding =ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}