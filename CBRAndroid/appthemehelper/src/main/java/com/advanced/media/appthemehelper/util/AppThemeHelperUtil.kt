package com.advanced.media.appthemehelper.util

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.AttrRes
import androidx.annotation.RequiresApi
import kotlin.use

object AppThemeHelperUtil {

    @RequiresApi(Build.VERSION_CODES.S)
    fun isWindowBackgroundBlack(context: Context): Boolean {
        return !ColorUtil.isColorLight(resolveColor(context, android.R.attr.windowBackground))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @JvmOverloads
    fun resolveColor(context: Context, @AttrRes attr: Int, fallback: Int = 0): Int {
        context.theme.obtainStyledAttributes(intArrayOf(attr)).use {
            return try {
                it.getColor(0, fallback)
            } catch (_: Exception) {
                Color.BLACK
            }
        }
    }

}