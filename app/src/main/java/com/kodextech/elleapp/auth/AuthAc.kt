package com.kodextech.elleapp.auth

import android.os.Bundle
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.DialogFragment
import com.kodextech.cleaques.base.BaseActivity
import com.kodextech.cleaques.utils.getCountryDialCode
import com.kodextech.elleapp.R
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