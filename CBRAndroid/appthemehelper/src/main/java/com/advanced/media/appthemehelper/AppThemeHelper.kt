package com.advanced.media.appthemehelper

import android.content.Context
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import com.advanced.media.appthemehelper.util.TintHelper

object AppThemeHelper {

    fun didThemeValuesChange(context: Context, since: Long): Boolean {
        return ThemeStore.isConfigured(context)
                && ThemeStore.prefs(context).getLong(ThemeStorePrefKeys.VALUES_CHANGED, -1) > since
    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun setTint(view: View, @ColorInt color: Int) {
        TintHelper.setTintAuto(view, color, false)
    }

}