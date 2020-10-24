@file:Suppress("unused", "UNUSED_PARAMETER")

package com.kodextech.cleaques.base


import android.app.Dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.kodextech.cleaques.utils.HideUtil
import com.kodextech.elleapp.R

@Suppress("unused")
abstract class BaseActivity : AppCompatActivity() {

    //    private val pd = ProgressDialog.newInstance()
    private lateinit var mProgressBar: Dialog
    var mViewGroup: ViewGroup? = null

    fun sendTag() {
        //   OneSignal.sendTag("user_id", "${LocalPreference.shared.user?.id ?: 0}")
    }

    fun removeTag() {
//        OneSignal.removeExternalUserId()
//        OneSignal.deleteTag("user_id")
    }

    //
    fun makeTopBottomTransparent() {
        val w: Window = window // in Activity's onCreate() for instance
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,// or
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )// For Display Image View On Status Bar Background
    }


    fun hideLoading() {
        runOnUiThread {
            try {
//                if (pd.isAdded) pd.dismiss()
                hideProgressBar()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }


    fun makeLightContentStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val w: Window = window // in Activity's onCreate() for instance
        w.setFlags(
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR,
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        )// For Display Image View On Status Bar Background
    }

    fun makeDarkContentStatusBar() {
        window.clearFlags(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
    }

    fun setupScreenWidthHeight() {

//        val displaymetrics = DisplayMetrics()
//        this.windowManager.defaultDisplay.getMetrics(displaymetrics)
//        val screenWidth = displaymetrics.widthPixels
//        val screenHeight = displaymetrics.heightPixels
//        val display = windowManager.defaultDisplay
//        val size = Point()
//        display.getSize(size)
//        DataManager.setDeviceHeight(size.y)
//        DataManager.setDeviceWidth(size.x)
    }

    abstract fun onSetupViewGroup()

    fun showProgressDialog(text: String = "Please wait...") {
//        mProgressBar = Dialog(this)
//
//        mProgressBar.setContentView(R.layout.progress_bar)
//
//        mProgressBar.tv_progress_text.text = text
//
//        mProgressBar.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        mProgressBar.show()
    }

    fun hideProgressBar() {
        //      mProgressBar.dismiss()
    }


    fun showLoading(text: String = "Please wait...") {
        runOnUiThread {
            try {
//                if (!pd.isVisible && !pd.isAdded) {
//                    pd.show(supportFragmentManager, "pd")
//                }
//                Handler().postDelayed({
//                    pd.txtProgress?.text = text
//                }, 200)
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetupViewGroup()
        HideUtil.init(this, mViewGroup)


    }

    fun replaceFragment(fragment: Fragment?, tagForBackStack: String? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        if (tagForBackStack != null) {
            transaction.addToBackStack(tagForBackStack)
        }
        transaction.replace(R.id.action_container, fragment ?: Fragment())
        transaction.commitAllowingStateLoss()
    }

    fun addFragment(fragment: Fragment?, tagForBackStack: String? = null) {
        val transaction = supportFragmentManager.beginTransaction()
        if (tagForBackStack != null) {
            transaction.addToBackStack(tagForBackStack)
        }
        transaction.add(R.id.action_container, fragment ?: Fragment())
        transaction.commitAllowingStateLoss()
    }


    protected open fun onRecycle() {
        //
    }

    override fun onDestroy() {
        onRecycle()
        super.onDestroy()
    }

    protected open fun onBecameInvisibleToUser() {
        //
    }

    protected open fun onBecameVisibleToUser() {
        //
    }

    open fun onClickBtmState(view: View) {}

}


fun <T> generateList(response: String, type: Class<Array<T>>): ArrayList<T> {
    val arrayList = ArrayList<T>()
    if (response.isEmpty() || response == "null" || response == "\"[]\"") {
        return arrayList
    }
    arrayList.addAll(listOf(*Gson().fromJson<Array<T>>(response, type)))
    return arrayList
}

fun Any.toNotNullString(): String {

    return if (this == "null") {
        this.toString().replace("null", "")
    } else {
        this.toString()
    }
}

fun <T> List<T>.toArrayList(): ArrayList<T> {
    return ArrayList(this)
}

