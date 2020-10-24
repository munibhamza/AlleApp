package com.kodextech.elleapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.TelephonyManager
import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.kodextech.elleapp.R
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


fun String.doubleToStringNoDecimal(d: Double): String {
    val formatter = NumberFormat.getInstance(Locale.getDefault()) as DecimalFormat
    formatter.applyPattern("#,###")

    return formatter.format(d)
}

fun String.openMessenger(mContext: Context) {
//    val openURL = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/messages/compose?ids=$this"))
    val openURL =
        Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/$this"))
//    openURL.data =
//    openURL.data = Uri.parse("https://m.me/$this")
    mContext.startActivity(openURL)
}

fun String.openDialer(mContext: Context) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:${this}")
    mContext.startActivity(intent)
}


fun AppCompatEditText.text(value: String) {
    this.setText(value)
}

fun AppCompatTextView.text(value: String) {
    this.text = value
}


fun String.getStringWhole(): String {
    return this.trim()
}

fun Editable?.getStringWhole(): String {
    return this.toString().trim() ?: ""
}



fun String.capitalized(): String {
    return this.substring(0, 1).toUpperCase(Locale.getDefault()) + this.substring(1)
}

fun roundOff(d: Float, decimalPlace: Int): Float {
    var bd = BigDecimal(d.toString())
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP)
    return bd.toFloat()
}

fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPhone(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.PHONE.matcher(this).matches()
}

fun isValidEmail(target: CharSequence): Boolean {
    return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
}

fun isValidPhone(target: CharSequence): Boolean {
    return !TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches()
}

fun Context.getCountryDialCode(): String? {
    var contryId: String? = null
    var contryDialCode: String? = null
    val telephonyMngr = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    contryId = telephonyMngr.simCountryIso.toUpperCase(Locale.getDefault())
    val arrContryCode: Array<String> =
        this.resources.getStringArray(R.array.DialingCountryCode)
    for (i in arrContryCode.indices) {
        val arrDial = arrContryCode[i].split(",".toRegex()).toTypedArray()
        if (arrDial[1].trim { it <= ' ' } == contryId.trim()) {
            contryDialCode = arrDial[0]
            break
        }
    }
    return contryDialCode
}