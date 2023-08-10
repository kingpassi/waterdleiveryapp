package com.example.waterdleiveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.waterdleiveryapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= Firebase.auth
        with(binding){
            btnLogin.setOnClickListener {
                val email=edtLEmail.text.toString()
                val password=edtLPassword.text.toString()

                if(email!="" && password!=""){
                    auth.signInWithEmailAndPassword(email,password)
                        .addOnSuccessListener {
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                            finish()
                            Toast.makeText(this@LoginActivity,"Log in succesful", Toast.LENGTH_SHORT).show()

                        }.addOnFailureListener {

                            Toast.makeText(this@LoginActivity,"Log in  Fail",Toast.LENGTH_SHORT).show()
                            Log.d("TAG","${it.message}")
                            it.printStackTrace()
                        }
                }

            }


            tvGotoSignUp.setOnClickListener {
                startActivity(Intent(this@LoginActivity,SignUpActivity::class.java))
            }
        }



    }
}