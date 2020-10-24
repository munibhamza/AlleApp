package com.kodextech.elleapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.DialogFragment
import com.kodextech.cleaques.base.BaseActivity
import com.kodextech.cleaques.utils.getCountryDialCode
import com.kodextech.cleaques.utils.isValidPhone
import com.kodextech.cleaques.utils.showToast
import com.kodextech.elleapp.R
import com.kodextech.elleapp.dashboard.Dashboard
import com.ybs.countrypicker.CountryPicker
import kotlinx.android.synthetic.main.activity_auth.*
import java.io.Serializable

class AuthAc : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.authContent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_auth)
        super.onCreate(savedInstanceState)
        setListener()

        btnNext.setOnClickListener {
            //validation()
            startActivity(Intent(this@AuthAc,Dashboard::class.java))
        }
        tvSignupSiginIn.setOnClickListener {
            startActivity(Intent(this@AuthAc,SignUp::class.java))
        }

    }

    private fun validation() {
        val stPhonenum: String = tvCountrySiginIn.text.toString() + etPhone.text.toString()

        if(tvCountrySiginIn.text.toString().contains("null")){
            tvCountrySiginIn.text = "+1"
        }
        if(!stPhonenum.isValidPhone()){
            showToast("Phone Number Invalid")
            return
        }else if(etPassword.text.toString().isEmpty()){
            showToast("Password could not be empty")
            return
        }
        if (stPhonenum.isValidPhone() && etPassword.length() > 0) {
            //NetworkCall here

    }
    }


    private fun setListener() {
        tvCountrySiginIn.text = "+${getCountryDialCode()}"
        rlCountryPicker.setOnClickListener {
            val picker = CountryPicker.newInstance("Select Country")

            picker.setListener { name, code, dialCode, flagDrawableResID ->
                tvCountrySiginIn.text = dialCode
                picker.dismiss()
            }
            picker.setStyle(DialogFragment.STYLE_NORMAL, R.style.countrypicker_style)
            picker.show(supportFragmentManager, "Select Country")
        }
        btnNext.setOnClickListener {
        }
    }


}
class AuthOption(var phone: String, var password: String) : Serializable {}