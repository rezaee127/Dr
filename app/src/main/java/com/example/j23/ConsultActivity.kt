package com.example.j23

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.j23.databinding.ActivityConsultBinding
import ir.sample.doctorproject2.com.example.j23.ConsultActivityViewModel
import ir.sample.doctorproject2.com.example.j23.Model.OnlineStatus


class ConsultActivity : AppCompatActivity() {
    lateinit var  binding : ActivityConsultBinding
    private lateinit var viewModel:ConsultActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState!= null){
            var myText = savedInstanceState.getString("textView1Text")
            binding.textView.text = myText
        }

        initViews()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("textView1Text" , binding.textView.text.toString())
        super.onSaveInstanceState(outState)
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        viewModel= ViewModelProvider(this).get(ConsultActivityViewModel::class.java)
        val id = intent.getIntExtra("id" , -1)
        if (id == -1){
            binding.textViewDoctorCalls.text = "ٔدکتر شما پیدا نشد"
        }else {
            val doctor = viewModel.hospital1.getDoctor(id)
            if (doctor?.onlineStatus==OnlineStatus.Online) {
                binding.textViewDoctorCalls.text = "میخواهید که ${doctor?.name} با شما تماس بگیرد؟ "
                binding.buttonDrCall.isEnabled = true
            }else{
                binding.textViewDoctorCalls.text = " متاسفانه ${doctor?.name} آنلاین نیست "
                binding.buttonDrCall.isEnabled = false
            }

        }

        if(getFromShared_name().isNullOrEmpty() ){
            binding.editTextName.error="نام را وارد کنید"
        }
        if(getFromShared_tel().isNullOrEmpty()){
            binding.editTextTel.error="تلفن را وارد کنید"
        }
        binding.buttonDrCall.setOnClickListener {
            getUserNameAndTel()
            openCheckActivity()
        }


        if (!getFromShared_name().isNullOrEmpty() ){
            binding.editTextName.visibility = View.GONE
        }
        if (!getFromShared_tel().isNullOrEmpty() ){
            binding.editTextTel.visibility = View.GONE
        }
    }

    private fun openCheckActivity() {
        val intent = Intent(this , CheckPatientActivity::class.java)
        startForResult.launch(intent)
    }

    private fun getUserNameAndTel() {
        var username = binding.editTextName.text.toString()
        var userTel = binding.editTextTel.text.toString()
        saveInShared(username , userTel)
    }

    private fun saveInShared(username: String, userTel: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name" , username)
        editor.putString("tel" , userTel)
        editor.apply()
    }
    private fun getFromShared_name() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name" , "")
        return name
    }
    private fun getFromShared_tel() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val tel = sharedPreferences.getString("tel" , "")
        return tel
    }
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val isOk =  intent?.getBooleanExtra("isOk", false)
                if(isOk==true && !getFromShared_tel().isNullOrEmpty()) {
                    binding.textViewDoctorCalls.visibility = View.INVISIBLE
                    binding.textView.text = getString(R.string.DrCall)
                }
                else{
                    binding.textViewDoctorCalls.visibility = View.INVISIBLE
                    binding.textView.text=getString(R.string.sorry)
                }


        }
    }
}