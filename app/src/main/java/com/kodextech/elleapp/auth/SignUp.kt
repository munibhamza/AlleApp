package com.kodextech.elleapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodextech.cleaques.base.BaseActivity
import com.kodextech.elleapp.R
import com.kodextech.elleapp.dashboard.Dashboard
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentSignup)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sign_up)
        super.onCreate(savedInstanceState)


        tvSigninSignup.setOnClickListener {
            startActivity(Intent(this@SignUp,AuthAc::class.java))
        }
        btnSignUp.setOnClickListener {
            //signup here
            //validation()
            startActivity(Intent(this@SignUp,Dashboard::class.java))
        }
    }

    private fun validation() {
        if(etFirstName.length() ==0 ){
            etFirstName.error = "First name required"
        }else if(etLastName.length() == 0){
            etLastName.error = "Last name required"
        }else if(etEmailSignUp.length() == 0){
            etEmailSignUp.error = "Street name required"
        }
        else if(etGenderSignUp.length() == 0){
            etGenderSignUp.error = "Postal code required"
        }else if(etDob.length() == 0){
            etDob.error = "City name required"
        }
        else if(etPasswordSignUp.length() == 0){
            etPasswordSignUp.error = "Bank number required"
        }else {

            //Network Call here
        }
    }
}