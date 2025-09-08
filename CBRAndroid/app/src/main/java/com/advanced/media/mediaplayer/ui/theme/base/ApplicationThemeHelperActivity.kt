package com.advanced.media.mediaplayer.ui.theme.base

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.advanced.media.appthemehelper.AppThemeHelper
import kotlinx.coroutines.launch

class ApplicationThemeHelperActivity : ComponentActivity() {

    private val TAG = ApplicationThemeHelperActivity::class.java.simpleName

    private var mUpdateTime = -1L // replace with your actual time-tracking logic

    private var mShouldRecreate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate [IN]")
        super.onCreate(savedInstanceState)
        mUpdateTime = System.currentTimeMillis()
        onThemeChanged()
        Log.d(TAG, "onCreate [OUT]")
    }

    override fun onStart() {
        Log.d(TAG, "onStart [IN]")
        super.onStart()
        if (mShouldRecreate) {
            mShouldRecreate = false
        }
        Log.d(TAG, "onStart [OUT]")
    }

    override fun onResume() {
        Log.d(TAG, "onResume [IN]")
        super.onResume()
        Log.d(TAG, "onResume [OUT]")
    }

    private fun onThemeChanged() {
        Log.d(TAG, "onThemeChanged [IN]")
        postRecreate()
        Log.d(TAG, "onThemeChanged [OUT]")
    }

    fun postRecreate() {
        // Wait until lifecycle is at least STARTED before recreating
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                if (AppThemeHelper.didThemeValuesChange(
                        this@ApplicationThemeHelperActivity,
                        mUpdateTime
                )) {
                    recreate()
                }
            }
        }
    }

}