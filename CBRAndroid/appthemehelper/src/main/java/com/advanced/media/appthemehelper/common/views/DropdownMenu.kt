package com.advanced.media.appthemehelper.common.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private const val TAG = "DropdownMenu"

@Composable
fun DropdownMenu(
    isExpanded: MutableState<Boolean>,
    backgroundColor: Color,
    contentColor: Color,
    ) {
    DropdownMenu(
        expanded = isExpanded.value,
        onDismissRequest = {
            Log.d(TAG, "[DropdownMenuItem][onDismissRequest][IN]")
            isExpanded.value = false
            Log.d(TAG, "[DropdownMenuItem][onDismissRequest][OUT]")
        },
        modifier = Modifier.background(backgroundColor)
    ) {
        DropdownMenuItem(
            text = {
                Text("Option 1")
            },
            onClick = {
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 1 <Net Size>][IN]")
                //TODO update later
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 1 <net Size>][OUT]")
            }
        )
        DropdownMenuItem(
            text = {
                Text("Option 2")
            },
            onClick = {
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 2 <Composition Net>][IN]")
                //TODO update later
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 2 <Composition Net>][OUT]")
            }
        )
        DropdownMenuItem(
            text = {
                Text("Option 3")
            },
            onClick = {
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 3 <Sort Ordering>][IN]")
                //TODO update later
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 3 <Sort Ordering>][OUT]")
            }
        )
        DropdownMenuItem(
            text = {
                Text("Option 4")
            },
            onClick = {
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 4 <Setting>][IN]")
                //TODO update later
                Log.d(TAG, "[DropdownMenuItem][onClick][Option 4 <Setting>][OUT]")
            }
        )
    }
}