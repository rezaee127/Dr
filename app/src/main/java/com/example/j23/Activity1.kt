package com.example.j23

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.j23.databinding.Activity1Binding
import ir.sample.doctorproject2.CustomAdapter
import ir.sample.doctorproject2.Doctor
import ir.sample.doctorproject2.Hospital
import ir.sample.doctorproject2.OnlineStatus
import ir.sample.doctorproject2.com.example.j23.SharedViewModel
import java.util.ArrayList

class Activity1 : AppCompatActivity() {
    lateinit var binding: Activity1Binding
    private lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)


        initViews()
        initList()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initList() {
        val adapter=CustomAdapter(ArrayList<Doctor>())
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter=adapter

        adapter.dataSet=viewModel.hospital.listOfDoctors
        adapter.notifyDataSetChanged()

        binding.recyclerView.setOnClickListener {

        }
    }



    private fun initViews() {
        val listOfButtons= arrayListOf(binding.button1,binding.button2)
        for (i in listOfButtons.indices) {
            listOfButtons[i].text = viewModel.hospital.listOfDoctors[i].name

            listOfButtons[i].setOnClickListener {
                goToDoctorActivity(viewModel.hospital.listOfDoctors[i].id)
            }
        }

    }


    private fun goToDoctorActivity(id: Int) {
        val intent = Intent(this, DoctorActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}