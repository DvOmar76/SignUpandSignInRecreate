package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signupandsignin.Model.DBHelper
import com.example.signupandsignin.databinding.ActivitySignInPageBinding

class SignInPage : AppCompatActivity() {
    lateinit var binding: ActivitySignInPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper=DBHelper(applicationContext)
        binding.btnSignIn.setOnClickListener {
           val name= binding.edName.text.toString()
           val password= binding.edPasswordSignIn.text.toString()
            val status =dbHelper.getUsers(name,password)
            if (status!=null){
                val intent=Intent(applicationContext,BasePage::class.java)
                intent.putExtra("name",name)
                intent.putExtra("mobile",name)
                intent.putExtra("location",name)
                startActivity(intent)
            }

        }
    }
}