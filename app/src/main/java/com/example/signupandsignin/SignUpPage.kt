package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signupandsignin.Model.DBHelper
import com.example.signupandsignin.databinding.ActivitySignUpPageBinding

class SignUpPage : AppCompatActivity() {
    lateinit var binding: ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dbHelper=DBHelper(applicationContext)
        binding.btnSubmit.setOnClickListener {
            var name=binding.edName.text.toString()
            var mobile=binding.edMobile.text.toString()
            var location=binding.edLocation.text.toString()
            var password=binding.edPassword.text.toString()
            if (name.isNotEmpty()&&mobile.isNotEmpty()&&location.isNotEmpty()&&password.isNotEmpty())
            {
                val status=dbHelper.addUser(name,mobile,location,password)
                if(status!=-1L){
                    Toast.makeText(applicationContext, "user is added ", Toast.LENGTH_SHORT).show()
                    val intent=Intent(applicationContext,BasePage::class.java)
                    intent.putExtra("name",name)
                    intent.putExtra("mobile",name)
                    intent.putExtra("location",name)
                    startActivity(intent)
                }
            }
        }
    }
}