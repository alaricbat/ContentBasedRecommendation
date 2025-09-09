package com.advanced.media.app.presentation.ui.screen.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.media3.common.Player

class PlayerViewModel(application: Application) : AndroidViewModel(application), Player.Listener {

}