package com.advanced.media.mediaplayer

import android.os.Bundle
import android.util.Log
import com.advanced.media.mediaplayer.ui.theme.base.ThemeActivity

class MainActivity : ThemeActivity() {

    companion object {
        private val TAG = MainActivity::javaClass.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate[IN]")
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate[OUT]")
    }

}