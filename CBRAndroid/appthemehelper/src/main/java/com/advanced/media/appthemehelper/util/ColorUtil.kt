package com.advanced.media.appthemehelper.util

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.core.graphics.ColorUtils

object ColorUtil {

    fun desaturatedColor(color: Int, ratio: Float) : Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[1] = hsv[1] / 1 * ratio + 0.2f * (1.0f - ratio)
        return Color.HSVToColor(hsv)
    }

    @ColorInt
    fun darkenColor(@ColorInt color: Int): Int {
        return shiftColor(color, 0.9f)
    }

    @ColorInt
    fun darkenColor(@ColorInt color: Int, value: Float): Int {
        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(color, hsl)
        hsl[2] -= value
        hsl[2] = hsl[2].coerceIn(0f, 1f)
        return ColorUtils.HSLToColor(hsl)
    }

    @ColorInt
    fun lightenColor(@ColorInt color: Int, value: Float): Int {
        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(color, hsl)
        hsl[2] += value
        hsl[2] = hsl[2].coerceIn(0f, 1f)
        return ColorUtils.HSLToColor(hsl)
    }

    @ColorInt
    fun shiftColor(@ColorInt color: Int, @FloatRange(from = 0.0, to = 2.0) by: Float): Int {
        if (by == 1f) return color
        val alpha = Color.alpha(color)
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= by // value component
        return (alpha shl 24) + (0x00ffffff and Color.HSVToColor(hsv))
    }

    fun isColorLight(@ColorInt color: Int): Boolean {
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness < 0.4
    }

    @ColorInt
    fun getReadableColorLight(@ColorInt color: Int, @ColorInt bgColor: Int): Int {
        var foregroundColor = color
        while (ColorUtils.calculateContrast(foregroundColor, bgColor) <= 3.0) {
            foregroundColor = darkenColor(foregroundColor, 0.1F)
        }
        return foregroundColor
    }

    @ColorInt
    fun getReadableColorDark(@ColorInt color: Int, @ColorInt bgColor: Int): Int {
        var foregroundColor = color
        while (ColorUtils.calculateContrast(foregroundColor, bgColor) <= 3.0) {
            foregroundColor = lightenColor(foregroundColor, 0.1F)
        }
        return foregroundColor
    }


}