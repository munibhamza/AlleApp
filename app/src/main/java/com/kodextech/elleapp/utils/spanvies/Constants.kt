package com.kodextech.cleaques.utils.spanvies

import android.content.Intent
import androidx.fragment.app.Fragment
import com.kodextech.cleaques.base.BaseActivity

object Constants {

    var isVendor: Boolean = true
    var isPost:Boolean = true

    const val LIMIT_PAGE = 10
    const val TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
    const val VALUE_PASS_BOOLEAN = "VALUE_PASS_BOOL"
    const val SPLASH_VALUE: Long = 3500
    const val HEADER_VIEW = 0
    const val FIRST_GROUP = 1
    const val SECOND_GROUP = 2
    const val THIRD_GROUP = 3
    const val FIRST_ITEMS = 4
    const val SECOND_ITEMS = 5
    const val THIRD_ITEMS = 6
    const val FAQ_HEADER = 8
    const val SUPPORT_HEADER = 9
    const val FAQ_ITEM = 10
    const val SUPPORT_ITEM = 11
    const val PIC_HEADER = 12
    const val PRONOS_MATCH = 13
    const val PRONOS_DESCRIPTION = 14
    const val GUIDE_DESCRIPTION = 15
    const val FLAG_TOKEN_RECEIVE = 1021
    fun goToActivity(
        context: BaseActivity,
        className: Class<*>?,
        isFinished: Boolean = true
    ) {
        val intent = Intent(context, className)
        context.startActivity(intent)
        if (isFinished) {
            context.finish()
        }
    }

    fun goToActivityWithResult(
        context: BaseActivity,
        className: Class<*>?,
        flagCode: Int
    ) {
        val intent = Intent(context, className)
        context.startActivityForResult(intent, flagCode)
    }

    fun goToActivityWithResult(
        context: Fragment,
        className: Class<*>?,
        flagCode: Int
    ) {
        val intent = Intent(context.requireContext(), className)
        context.startActivityForResult(intent, flagCode)
    }
}