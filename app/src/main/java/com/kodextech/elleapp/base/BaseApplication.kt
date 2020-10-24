@file:Suppress("unused")

package com.kodextech.elleapp.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor

open class BaseApplication : Application(), LifecycleObserver {


    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: BaseApplication? = null
        var inBackground = false
        var fontPoppinsBold: Typeface? = null
        var fontPoppinsRegular: Typeface? = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onMoveToForeground() {
        // app moved to foreground
        Log.e("inBackground", "false")
        inBackground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onMoveToBackground() {
        // app moved to background
        Log.e("inBackground", "true")
        inBackground = true
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(this@BaseApplication)
        fontPoppinsBold = Typeface.createFromAsset(assets, "fonts/poppins_bold.ttf")
        fontPoppinsRegular =
            Typeface.createFromAsset(assets, "fonts/poppins_regular.ttf")
//        OneSignal.startInit(this)
//            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//            .unsubscribeWhenNotificationsAreDisabled(true)
//            .setNotificationReceivedHandler(OneSignalNotificationReceivedHandler(this))
//            .setNotificationOpenedHandler(OneSignalNotificationOpenedHandler(this))
//            .init()
        AndroidNetworking.initialize(this)
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.HEADERS)
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BASIC)

//        FacebookSdk.sdkInitialize(applicationContext)
//        AppEventsLogger.activateApp(this)

    }


}

//
//@GlideModule
//class YourAppGlideModule : AppGlideModule() {
//    override fun applyOptions(context: Context, builder: GlideBuilder) {
//        builder.setLogLevel(Log.WARN)
//        super.applyOptions(context, builder)
//    }
////    override fun applyOptions(context: Context?, builder: GlideBuilder) {
////        builder.setLogLevel(Log.DEBUG)
////    }
//}