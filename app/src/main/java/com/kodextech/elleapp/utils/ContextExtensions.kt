package com.kodextech.elleapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.Log

fun Context.printLog(message: Any?, tag: String = "Frenzy") {
    Log.d(tag, message?.toString() ?: "")
}

fun printLog(message: Any?, tag: String = "Frenzy") {
    Log.d(tag, message?.toString() ?: "")
}

fun Context.drawableToBitmap(drawable: Drawable): Bitmap {
    val size = (60 * resources.displayMetrics.density).toInt()
    val mutableBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(mutableBitmap)
    drawable.setBounds(0, 0, size, size)
    drawable.draw(canvas)
    return mutableBitmap
}

fun Float.toPx(context: Context) = (this * context.resources.displayMetrics.scaledDensity + 0.5F)