package com.advanced.media.appthemehelper.common.views

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.advanced.media.appthemehelper.R

private const val TAG = "CenterAlignedTopAppBar"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBar(
) {
    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    // Controls expansion state of the search bar
    var expanded by rememberSaveable { mutableStateOf(false) }
    var isDropdownMenuExpanded by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
            TextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                placeholder = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Search",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(100.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            //TODO update later
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            IconButton(onClick = {
                //TODO update later
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Navigation icon."
                )
            }
        },
        actions = {
            IconButton (
                onClick = {
                    Log.d(TAG, "[IconButton][Menu][IN]")
                    //TODO update later
                    Log.d(TAG, "[IconButton][Menu][OUT]")
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_connect_pc),
                    contentDescription = "Connect to Monitor Button."
                )
            }
            Box {
                IconButton(
                    onClick = {
                        Log.d(TAG, "[IconButton][MoreVert][IN]")
                        isDropdownMenuExpanded = true
                        Log.d(TAG, "[IconButton][MoreVert][OUT]")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Configuration Button."
                    )
                }
                DropdownMenu(
                    isExpanded = remember { mutableStateOf(isDropdownMenuExpanded) },
                    backgroundColor = Color.Black,
                    contentColor = Color.Red
                )
            }
        }
    )
}

@Preview
@Composable
fun PreviewCenterAlignedTopAppBar() {
    CenterAlignedTopAppBar()
}
