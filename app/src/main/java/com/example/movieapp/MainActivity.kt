package com.example.movieapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.movieapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    // View binding
    private lateinit var binding: ActivityMainBinding


    // ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    // FireBaseAuth
    private lateinit var fireBaseAuth: FirebaseAuth

    // global values
    private var email = ""
    private var password = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait ")
        progressDialog.setMessage("logging In...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init fireBaseAuth
        fireBaseAuth = FirebaseAuth.getInstance()
        checkUser()

        // handle click, open register activity
        binding.noAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }


        // handle click, begin login
        binding.loginBtn.setOnClickListener {
            // before logging in, validate data
            validateData()
        }

    }

    private fun validateData() {
        //get Data
        email = binding.emailField.text.toString().trim()
        password = binding.passwordField.text.toString().trim()

        //validate data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.emailField.error = "Invalid email format"
        }
        else if(TextUtils.isEmpty(password)){
            //password empty
            binding.passwordField.error = "Please enter password"
        }else{
            //data is validated
            fireBaseLogin()
        }
    }

    private fun fireBaseLogin() {
        // show progress
        progressDialog.show()
        fireBaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //login success
                progressDialog.dismiss()

                //get user info
                val fireBaseUser = fireBaseAuth.currentUser
                val email = fireBaseUser!!.email
                Toast.makeText(this,"logged-In as $email", Toast.LENGTH_SHORT).show()

                   //open profile
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            }
            .addOnFailureListener { e->
                // login failed
                progressDialog.dismiss()
                Toast.makeText(this,"login failed due to${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        //if user is already logged in, goto profile activity
        //get current user
        val fireBaseUser = fireBaseAuth.currentUser
        if(fireBaseUser != null){
              //user is already logged in
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}