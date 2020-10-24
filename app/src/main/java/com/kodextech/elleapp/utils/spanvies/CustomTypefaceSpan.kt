package com.kodextech.cleaques.utils.spanvies

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.TypefaceSpan
import android.view.View

class CustomTypefaceSpan : TypefaceSpan {
    private val newType: Typeface?

    constructor(type: Typeface?) : super("") {
        newType = type
    }

    constructor(family: String?, type: Typeface) : super(family) {
        newType = type
    }

    override fun updateDrawState(textPaint: TextPaint) {
        applyCustomTypeFace(textPaint, newType)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, newType)
    }

    companion object {
        private fun applyCustomTypeFace(paint: Paint, tf: Typeface?) {
            val oldStyle: Int
            val old = paint.typeface
            oldStyle = old?.style ?: 0
            val fake = oldStyle and (tf?.style?.inv() ?: 0)
            if (fake and Typeface.BOLD != 0) {
                paint.isFakeBoldText = true
            }
            if (fake and Typeface.ITALIC != 0) {
                paint.textSkewX = -0.25f
            }
            paint.typeface = tf
        }
    }
}


class CustomTypefaceSpanWithClick(
    type: Typeface?,
    isUnderLineValue: Boolean = true,
    color: Int = Color.WHITE,
    private val listener: () -> Unit
) :
    ClickableSpan() {
    private val newType: Typeface? = type
    private val isUnderLine: Boolean = isUnderLineValue
    private val txtColor: Int = color

    override fun onClick(p0: View) {
        listener()
    }

    override fun updateDrawState(textPaint: TextPaint) {
        applyCustomTypeFace(textPaint, newType)
        textPaint.isUnderlineText = isUnderLine
        textPaint.color = txtColor
        textPaint.typeface = newType
    }


    companion object {
        private fun applyCustomTypeFace(paint: Paint, tf: Typeface?) {
            val oldStyle: Int
            val old = paint.typeface
            oldStyle = old?.style ?: 0
            val fake = oldStyle and (tf?.style?.inv() ?: 0)
            if (fake and Typeface.BOLD != 0) {
                paint.isFakeBoldText = true
            }
            if (fake and Typeface.ITALIC != 0) {
                paint.textSkewX = -0.25f
            }
            paint.typeface = tf
        }
    }
}