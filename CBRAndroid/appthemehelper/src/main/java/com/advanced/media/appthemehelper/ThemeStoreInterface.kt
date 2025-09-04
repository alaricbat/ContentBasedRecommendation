package com.advanced.media.appthemehelper

import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StyleRes

interface ThemeStoreInterface {

    //Activity Theme

    fun activityTheme(@StyleRes theme: Int): ThemeStore

    //Primary Colors

    fun primaryColor(@ColorInt color: Int): ThemeStore

    fun primaryColorRes(@ColorRes colorRes: Int): ThemeStore

    fun primaryColorAttr(@AttrRes colorAttr: Int): ThemeStore

    fun autoGeneratePrimaryDark(autoGenerate: Boolean): ThemeStore

    fun primaryColorDark(@ColorInt color: Int): ThemeStore

    fun primaryColorDarkRes(@ColorRes colorRes: Int): ThemeStore

    fun primaryColorDarkAttr(@AttrRes colorAttr: Int): ThemeStore

    //Accent Colors

    fun accentColor(@ColorInt color: Int): ThemeStore

    fun wallpaperColor(context: Context, color: Int): ThemeStore

    fun accentColorRes(@ColorRes colorRes: Int): ThemeStore

    fun accentColorAttr(@AttrRes colorAttr: Int): ThemeStore

    //Status Bar Color

    fun statusBarColor(@ColorInt color: Int): ThemeStore

    fun statusBarColorRes(@ColorRes colorRes: Int): ThemeStore

    fun statusBarColorAttr(@AttrRes colorAttr: Int): ThemeStore

    //Navigation Bar Color

    fun navigationBarColor(@ColorInt color: Int): ThemeStore

    fun navigationBarColorRes(@ColorRes colorRes: Int): ThemeStore

    fun navigationBarColorAttr(@AttrRes colorAttr: Int): ThemeStore

    //Primary Text Color

    fun textColorPrimary(@ColorInt color: Int): ThemeStore

    fun textColorPrimaryRes(@ColorRes colorRes: Int): ThemeStore

    fun textColorPrimaryAttr(@AttrRes colorAttr: Int): ThemeStore

    fun textColorPrimaryInverse(@ColorInt color: Int): ThemeStore

    fun textColorPrimaryInverseRes(@ColorRes colorRes: Int): ThemeStore

    fun textColorPrimaryInverseAttr(@AttrRes colorAttr: Int): ThemeStore

    // Secondary Text Color

    fun textColorSecondary(@ColorInt color: Int): ThemeStore

    fun textColorSecondaryRes(@ColorRes colorRes: Int): ThemeStore

    fun textColorSecondaryAttr(@AttrRes colorAttr: Int): ThemeStore

    fun textColorSecondaryInverse(@ColorInt color: Int): ThemeStore

    fun textColorSecondaryInverseRes(@ColorRes colorRes: Int): ThemeStore

    fun textColorSecondaryInverseAttr(@AttrRes colorAttr: Int): ThemeStore

    // Toggle Configuration

    fun coloredStatusBar(colored: Boolean): ThemeStore

    fun coloredNavigationBar(applyToNavBar: Boolean): ThemeStore

    //Commit/Apply

    fun commit()


}