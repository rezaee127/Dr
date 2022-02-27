package com.example.j23

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.j23.databinding.ActivityConsultBinding
import ir.sample.doctorproject2.Hospital
import ir.sample.doctorproject2.OnlineStatus

class ConsultActivity : AppCompatActivity() {
    lateinit var  binding : ActivityConsultBinding
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
        var id = intent.getIntExtra("id" , -1)
        if (id == -1){
            binding.textViewDoctorCalls.text = "ٔدکتر شما پیدا نشد"
        }else {
            var doctor = Hospital.getDoctor(id)
            if (doctor?.onlineStatus==OnlineStatus.Online) {
                binding.textViewDoctorCalls.text = " ${doctor?.name} با شما تماس خواهد گرفت"
                binding.buttonDrCall.isEnabled = true
            }else{
                binding.textViewDoctorCalls.text = " متاسفانه ${doctor?.name} آنلاین نیست "
                binding.buttonDrCall.isEnabled = false
            }

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
            isOk?.let{
                if(it)
                    binding.textView.text="الان دکتر بهت زنگ می زنه"
                else
                    binding.textView.text="متاسفانه شما آمادگی صحبت ندارید. در اولین فرصت دوباره تلاش کنید"
            }
        }
    }
}