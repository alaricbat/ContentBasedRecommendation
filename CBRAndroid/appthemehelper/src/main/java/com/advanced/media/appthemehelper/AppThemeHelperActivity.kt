package com.advanced.media.appthemehelper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

open class AppThemeHelperActivity : ComponentActivity() {

    companion object {
        private val TAG = AppThemeHelperActivity::class.java.simpleName
    }

    private var mUpdateTime = -1L // replace with your actual time-tracking logic

    private var mShouldRecreate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate [IN]")
        super.onCreate(savedInstanceState)
        mUpdateTime = System.currentTimeMillis()
        onThemeChanged()
        setContent {
            RenderContent()
        }
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
        Log.d(TAG, "postRecreate [IN]")
        // Wait until lifecycle is at least STARTED before recreating
        lifecycleScope.launch {
            Log.d(TAG, "[postRecreate][Thread]:- ${Thread.currentThread().name}")
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                if (AppThemeHelper.didThemeValuesChange(
                        this@AppThemeHelperActivity,
                        mUpdateTime
                )) {
                    recreate()
                }
            }
        }
        Log.d(TAG, "postRecreate [OUT]")
    }

    @Composable
    open fun RenderContent() {
        //Do thing
    }

}