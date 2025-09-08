package com.advanced.media.appthemehelper.util

import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi

object TintHelper {

    @RequiresApi(Build.VERSION_CODES.S)
    fun setTintAuto(view: View, @ColorInt color: Int,
                    background: Boolean) {
        setTintAuto(view,
            color,
            background,
            AppThemeHelperUtil.isWindowBackgroundBlack(view.context))
    }

    fun setTintAuto(view: View, @ColorInt color: Int,
                    background: Boolean, isDark: Boolean) {
        if (!background) {
            //
        } else {
            //
        }
    }

}