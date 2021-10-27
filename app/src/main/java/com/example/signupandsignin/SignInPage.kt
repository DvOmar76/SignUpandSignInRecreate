package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signupandsignin.Model.DBHelper
import com.example.signupandsignin.databinding.ActivitySignInPageBinding
import java.lang.Exception

class SignInPage : AppCompatActivity() {
    lateinit var binding: ActivitySignInPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper=DBHelper(applicationContext)
        binding.btnSignIn.setOnClickListener {

            try {
                val mobile= binding.edMobile.text.toString().toInt()
                val password= binding.edPasswordSignIn.text.toString()
                if (password.isNotEmpty())
                {
                    val status = dbHelper.getUsers(mobile, password)
                    if (status != null)
                    {
                        val intent = Intent(applicationContext, BasePage::class.java)
                        intent.putExtra("name", status.name)
                        intent.putExtra("mobile",status.mobile )
                        intent.putExtra("location", status.location)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "info is not matching", Toast.LENGTH_SHORT).show()
                    }

                }

            }
            catch (e:Exception)
            {
                Toast.makeText(applicationContext, "pleas enter number in mobile", Toast.LENGTH_SHORT).show()

            }

        }
    }
}