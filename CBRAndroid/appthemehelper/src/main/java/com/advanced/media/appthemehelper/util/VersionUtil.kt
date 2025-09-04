package com.advanced.media.appthemehelper.util

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

object VersionUtil {

    /**
     * @return true if device is running API >= 31
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    @JvmStatic
    fun hasS(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    }

}