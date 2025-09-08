package com.advanced.media.appthemehelper

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.annotation.CheckResult
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.preference.PreferenceManager
import com.advanced.media.appthemehelper.util.AppThemeHelperUtil
import com.advanced.media.appthemehelper.util.AppThemeHelperUtil.resolveColor
import com.advanced.media.appthemehelper.util.ColorUtil
import com.advanced.media.appthemehelper.util.VersionUtil

class ThemeStore private constructor(
    private val mContext: Context
) : ThemeStorePrefKeys, ThemeStoreInterface {

    private val mEditor: SharedPreferences.Editor = prefs(mContext).edit()

    override fun activityTheme(theme: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_ACTIVITY_THEME, theme)
        return this
    }

    override fun primaryColor(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_PRIMARY_COLOR, color)
        if(autoGeneratePrimaryDark(mContext))
            primaryColorDark(ColorUtil.darkenColor(color))
        return this
    }

    override fun primaryColorRes(colorRes: Int): ThemeStore {
        return primaryColor(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun primaryColorAttr(colorAttr: Int): ThemeStore {
        return primaryColor(resolveColor(mContext, colorAttr))
    }

    override fun autoGeneratePrimaryDark(autoGenerate: Boolean): ThemeStore {
        mEditor.putBoolean(ThemeStorePrefKeys.KEY_AUTO_GENERATE_PRIMARY_DARK, autoGenerate)
        return this
    }

    override fun primaryColorDark(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_PRIMARY_COLOR_DARK, color)
        return this
    }

    override fun primaryColorDarkRes(colorRes: Int): ThemeStore {
        return primaryColorDark(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun primaryColorDarkAttr(colorAttr: Int): ThemeStore {
        return primaryColorDark(resolveColor(mContext, colorAttr))
    }

    override fun accentColor(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_ACCENT_COLOR, color)
        return this
    }

    override fun wallpaperColor(
        context: Context,
        color: Int
    ): ThemeStore {
        if (ColorUtil.isColorLight(color)) {
            mEditor.putInt(ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_DARK, color)
            mEditor.putInt(
                ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_LIGHT,
                ColorUtil.getReadableColorLight(
                    color,
                    Color.WHITE
                )
            )
        } else {
            mEditor.putInt(ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_LIGHT, color)
            mEditor.putInt(
                ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_DARK,
                ColorUtil.getReadableColorDark(
                    color,
                    "#202124".toColorInt()
                )
            )
        }
        return this
    }

    override fun accentColorRes(colorRes: Int): ThemeStore {
        return accentColor(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun accentColorAttr(colorAttr: Int): ThemeStore {
        return accentColor(resolveColor(mContext, colorAttr))
    }

    override fun statusBarColor(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_STATUS_BAR_COLOR, color)
        return this
    }

    override fun statusBarColorRes(colorRes: Int): ThemeStore {
        return statusBarColor(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun statusBarColorAttr(colorAttr: Int): ThemeStore {
        return statusBarColor(resolveColor(mContext, colorAttr))
    }

    override fun navigationBarColor(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_NAVIGATION_BAR_COLOR, color)
        return this
    }

    override fun navigationBarColorRes(colorRes: Int): ThemeStore {
        return navigationBarColor(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun navigationBarColorAttr(colorAttr: Int): ThemeStore {
        return navigationBarColor(resolveColor(mContext, colorAttr))
    }

    override fun textColorPrimary(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_TEXT_COLOR_PRIMARY, color)
        return this
    }

    override fun textColorPrimaryRes(colorRes: Int): ThemeStore {
        return textColorPrimary(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun textColorPrimaryAttr(colorAttr: Int): ThemeStore {
        return textColorPrimary(resolveColor(mContext, colorAttr))
    }

    override fun textColorPrimaryInverse(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_TEXT_COLOR_PRIMARY_INVERSE, color)
        return this
    }

    override fun textColorPrimaryInverseRes(colorRes: Int): ThemeStore {
        return textColorPrimaryInverse(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun textColorPrimaryInverseAttr(colorAttr: Int): ThemeStore {
        return textColorPrimaryInverse(resolveColor(mContext, colorAttr))
    }

    override fun textColorSecondary(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_TEXT_COLOR_SECONDARY, color)
        return this
    }

    override fun textColorSecondaryRes(colorRes: Int): ThemeStore {
        return textColorSecondary(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun textColorSecondaryAttr(colorAttr: Int): ThemeStore {
        return textColorSecondary(resolveColor(mContext, colorAttr))
    }

    override fun textColorSecondaryInverse(color: Int): ThemeStore {
        mEditor.putInt(ThemeStorePrefKeys.KEY_TEXT_COLOR_SECONDARY_INVERSE, color)
        return this
    }

    override fun textColorSecondaryInverseRes(colorRes: Int): ThemeStore {
        return textColorPrimaryInverse(ContextCompat.getColor(mContext, colorRes))
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun textColorSecondaryInverseAttr(colorAttr: Int): ThemeStore {
        return textColorPrimaryInverse(resolveColor(mContext, colorAttr))
    }

    override fun coloredStatusBar(colored: Boolean): ThemeStore {
        mEditor.putBoolean(ThemeStorePrefKeys.KEY_APPLY_PRIMARY_DARK_STATUS_BAR, colored)
        return this
    }

    override fun coloredNavigationBar(applyToNavBar: Boolean): ThemeStore {
        mEditor.putBoolean(ThemeStorePrefKeys.KEY_APPLY_PRIMARY_NAVBAR, applyToNavBar)
        return this
    }

    override fun commit() {
        mEditor.putLong(ThemeStorePrefKeys.VALUES_CHANGED, System.currentTimeMillis())
            .putBoolean(ThemeStorePrefKeys.IS_CONFIGURED_KEY, true)
            .commit()
    }

    companion object {

        fun editTheme(context: Context): ThemeStore {
            return ThemeStore(context)
        }

        @CheckResult
        fun prefs(context: Context): SharedPreferences {
            return context.getSharedPreferences(
                ThemeStorePrefKeys.CONFIG_PREFS_KEY_DEFAULT,
                Context.MODE_PRIVATE
            )
        }

        fun markChanged(context: Context) {
            ThemeStore(context).commit()
        }

        @RequiresApi(Build.VERSION_CODES.S)
        @CheckResult
        @ColorInt
        fun primaryColor(context: Context): Int {
            return prefs(context).getInt(
                ThemeStorePrefKeys.KEY_PRIMARY_COLOR,
                resolveColor(context,
                    androidx.appcompat.R.attr.colorPrimary,
                    "#455A64".toColorInt())
            )
        }

        @CheckResult
        @ColorInt
        fun accentColor(context: Context): Int {
            // Set MD3 accent if MD3 is enabled or in-app accent otherwise
            if (isMD3Enabled(context) && VersionUtil.hasS()) {
                return ContextCompat.getColor(context, R.color.m3_accent_color)
            }
            val desaturatedColor = prefs(context).getBoolean(
                ThemeStorePrefKeys.KEY_DESATURATED_COLOR, false)
            val color = if (isWallpaperAccentEnabled(context)) {
                wallpaperColor(context, AppThemeHelperUtil.isWindowBackgroundBlack(context))
            } else {
                prefs(context).getInt(
                    ThemeStorePrefKeys.KEY_ACCENT_COLOR,
                    resolveColor(context,
                        androidx.appcompat.R.attr.colorAccent,
                        "#263238".toColorInt())
                )
            }
            return if (AppThemeHelperUtil.isWindowBackgroundBlack(context) && desaturatedColor) ColorUtil.desaturatedColor(
                color, 0.4f)
            else color
        }

        @RequiresApi(Build.VERSION_CODES.S)
        @CheckResult
        @ColorInt
        private fun wallpaperColor(context: Context, isDarkMode: Boolean): Int {
            return prefs(context).getInt(
                if (isDarkMode) ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_DARK else ThemeStorePrefKeys.KEY_WALLPAPER_COLOR_LIGHT,
                resolveColor(context, androidx.appcompat.R.attr.colorAccent, "#263238".toColorInt())
            )
        }

        @CheckResult
        private fun autoGeneratePrimaryDark(context: Context): Boolean {
            return prefs(context).getBoolean(ThemeStorePrefKeys.KEY_AUTO_GENERATE_PRIMARY_DARK, true)
        }

        @CheckResult
        fun isConfigured(context: Context): Boolean {
            return prefs(context).getBoolean(ThemeStorePrefKeys.IS_CONFIGURED_KEY, false)
        }

        //Check Material Design 3
        fun isMD3Enabled(context: Context): Boolean {
            return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(ThemeStorePrefKeys.KEY_MATERIAL_YOU, VersionUtil.hasS())
        }


        private fun isWallpaperAccentEnabled(context: Context): Boolean {
            return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(ThemeStorePrefKeys.KEY_WALLPAPER_ACCENT, false)
        }

    }

}