package com.example.j23

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.j23.databinding.ActivityDoctorBinding
import ir.sample.doctorproject2.com.example.j23.DoctorActivityViewModel
import ir.sample.doctorproject2.com.example.j23.Model.Doctor


class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    private lateinit var viewModel: DoctorActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_doctor)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(DoctorActivityViewModel::class.java)
        val id = intent.getIntExtra("id", 0)

        var doctor = viewModel.hospital.getDoctor(id)
        binding.textViewName.text = doctor?.name
        binding.textViewOnline.text = doctor?.onlineStatus.toString()
        binding.textViewExpertise.text = doctor?.expertise

        binding.buttonCall.setOnClickListener {
            call(doctor?.phone)
        }
        setConsultancyType()

        binding.llConsultancy.setOnClickListener {
            goToConsultActivity(doctor)
        }
        binding.llConsultancy2.setOnClickListener {
            goToConsultActivity(doctor)
        }
        binding.llConsultancy3.setOnClickListener {
            goToConsultActivity(doctor)
        }

    }


    private  fun goToConsultActivity(doctor: Doctor?){
        val intent = Intent(this , ConsultActivity::class.java)
        intent.putExtra("id" , doctor?.id)
        startActivity(intent)

    }

    @SuppressLint("SetTextI18n")
    private fun setConsultancyType() {

        val cons1 = viewModel.listOfConsultancy[0]
        binding.consultancy.text = "مشاوره تلفنی ${cons1.time} دقیقه ای "
        binding.price.text = "${cons1.price} تومان "

        val cons2 =  viewModel.listOfConsultancy[1]
        binding.consultancy2.text = "مشاوره تلفنی ${cons2.time} دقیقه ای "
        binding.price2.text = "${cons2.price} تومان "

        val cons3 =  viewModel.listOfConsultancy[2]
        binding.consultancy3.text = "مشاوره تلفنی ${cons3.time} دقیقه ای "
        binding.price3.text = "${cons3.price} تومان "
    }

    private fun call(phone: String?) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phone")
        startActivity(callIntent)
    }
}