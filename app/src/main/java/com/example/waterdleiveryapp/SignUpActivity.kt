package com.example.waterdleiveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.waterdleiveryapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= Firebase.auth
        with(binding){

            btnSignup.setOnClickListener {
                val email= edtSEmail.text.toString()
                val password=edtSPassword.text.toString()


                if(email!="" && password!=""){
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnSuccessListener {
                            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
                            Toast.makeText(this@SignUpActivity,"sign up succesful",Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this@SignUpActivity,"${it.message}",Toast.LENGTH_SHORT).show()
                            Log.d("TAG","${it.message}")
                            it.printStackTrace()

                        }
                }



            }

            tvGotoLogin.setOnClickListener {
                startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
            }


        }



    }
}