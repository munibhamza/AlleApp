package com.kodextech.cleaques.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import render.animations.Attention
import render.animations.Render


fun View.shake() {
    val render = Render(this.context)
    render.setAnimation(Attention().Shake(this))//(Bounce().InDown(this))
    render.start()
}

fun View.bounce() {
    val render = Render(this.context)
    render.setAnimation(Attention().Bounce(this))//(Bounce().InDown(this))
    render.start()
}

fun View.flash() {
    val render = Render(this.context)
    render.setAnimation(Attention().Flash(this))//(Bounce().InDown(this))
    render.start()
}

fun View.pulse() {
    val render = Render(this.context)
    render.setAnimation(Attention().Pulse(this))//(Bounce().InDown(this))
    render.start()
}


fun View.viewVisible() {
    this.visibility = View.VISIBLE
}

fun View.viewGone() {
    this.visibility = View.GONE
}

fun View.viewInVisible() {
    this.visibility = View.INVISIBLE
}

fun View.viewVisibility(): Int {
    return this.visibility
}

fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

fun View.isInVisible(): Boolean {
    return this.visibility == View.INVISIBLE
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
