package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signupandsignin.Model.DBHelper
import com.example.signupandsignin.databinding.ActivityBasePageBinding

class BasePage : AppCompatActivity() {
    lateinit var binding: ActivityBasePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBasePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra("name")
        val mobile=intent.getStringExtra("mobile")
        val location=intent.getStringExtra("location")
        binding.tvWelcome.text="welcome $mobile"
        binding.tvDetails.text="${name}\n${location}\n"
        binding.btnSignOut.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }
}