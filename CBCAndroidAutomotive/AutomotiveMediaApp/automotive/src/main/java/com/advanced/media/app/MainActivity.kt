package com.advanced.media.app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.advanced.media.app.presentation.ui.constant.DEFAULT_CONTROLLABLE_INSETS
import com.advanced.media.app.presentation.ui.constant.LocalControllableInsets
import com.advanced.media.app.presentation.ui.ext.updateAttributes
import com.advanced.media.app.presentation.ui.theme.AutomotiveMediaTheme

class MainActivity : ComponentActivity() {

    private lateinit var mOnControllableInsetsChangedListener: WindowInsetsControllerCompat.OnControllableInsetsChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.updateAttributes {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                layoutInDisplayCutoutMode = resources.getInteger(R.integer.windowLayoutInDisplayCutoutMode)
            }
        }

        setContent {

            var controllableInsetsTypeMask by remember { mutableIntStateOf(
                DEFAULT_CONTROLLABLE_INSETS
            ) }

            mOnControllableInsetsChangedListener =
                WindowInsetsControllerCompat.OnControllableInsetsChangedListener { _, typeMask ->
                    if (controllableInsetsTypeMask != typeMask) {
                        controllableInsetsTypeMask = typeMask
                    }
            }

            WindowCompat.getInsetsController(window, window.decorView)
                .addOnControllableInsetsChangedListener(mOnControllableInsetsChangedListener)

            CompositionLocalProvider(
                LocalControllableInsets provides controllableInsetsTypeMask
            ) {
                AutomotiveMediaTheme {
                    //Do nothing
                }
            }

        }

    }

}