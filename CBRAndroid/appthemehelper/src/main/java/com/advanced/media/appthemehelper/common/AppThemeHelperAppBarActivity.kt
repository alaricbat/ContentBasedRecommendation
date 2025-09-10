package com.advanced.media.appthemehelper.common

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.advanced.media.appthemehelper.AppThemeHelperActivity
import com.advanced.media.appthemehelper.common.views.CenterAlignedTopAppBar

open class AppThemeHelperAppBarActivity: AppThemeHelperActivity() {

    companion object {
        private val TAG = AppThemeHelperAppBarActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate[IN]")
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate[OUT]")
    }

    @Composable
    override fun RenderContent() {
        Log.d(TAG, "RenderContent[IN]")
        super.RenderContent()
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar()
            }
        ) { innerPadding ->
            Text(
                text = "Hello world!",
                modifier = Modifier.Companion.padding(innerPadding)
            )
        }
        Log.d(TAG, "RenderContent[OUT]")
    }

}