package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signupandsignin.Model.DBHelper
import com.example.signupandsignin.databinding.ActivitySignUpPageBinding
import java.lang.Exception

class SignUpPage : AppCompatActivity() {
    lateinit var binding: ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dbHelper=DBHelper(applicationContext)
        binding.btnSubmit.setOnClickListener {

            try {
                var name=binding.edName.text.toString()
                var mobile=binding.edMobile.text.toString().toInt()
                var location=binding.edLocation.text.toString()
                var password=binding.edPassword.text.toString()
                if (name.isNotEmpty()&&location.isNotEmpty()&&password.isNotEmpty())
                {
                    val status=dbHelper.addUser(name,mobile,location,password)
                    if(status!=-1L)
                    {
                        Toast.makeText(applicationContext, "user is added ", Toast.LENGTH_SHORT).show()
                        val intent=Intent(applicationContext,BasePage::class.java)
                        intent.putExtra("name",name)
                        intent.putExtra("mobile",mobile.toString())
                        intent.putExtra("location",location)
                        startActivity(intent)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "this mobile is already registered", Toast.LENGTH_SHORT).show()

                    }
                }
                else
                {
                    Toast.makeText(applicationContext, "pleas complete the fields", Toast.LENGTH_SHORT).show()

                }
            }catch (e:Exception){
                Toast.makeText(applicationContext, "pleas enter number in mobile", Toast.LENGTH_SHORT).show()
            }
           
        }
    }
}
