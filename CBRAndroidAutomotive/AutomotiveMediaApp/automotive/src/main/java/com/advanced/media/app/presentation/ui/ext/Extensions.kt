package com.advanced.media.app.presentation.ui.ext

import android.view.Window
import android.view.WindowManager

fun Window.updateAttributes(block: WindowManager.LayoutParams.() -> Unit) {
    val layoutParams = WindowManager.LayoutParams()
    layoutParams.copyFrom(this.attributes)
    layoutParams.apply {
        block()
    }
    this.attributes = layoutParams
}

enum class SupportedOrientation {
    Landscape,
    Portrait
}

