package com.advanced.media.mediaplayer.ui.theme.base

import android.os.Bundle
import android.util.Log
import com.advanced.media.appthemehelper.common.AppThemeHelperAppBarActivity

open class ThemeActivity: AppThemeHelperAppBarActivity() {

    companion object {
        private val TAG = ThemeActivity::javaClass.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate[IN]")
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate[OUT]")
    }

}