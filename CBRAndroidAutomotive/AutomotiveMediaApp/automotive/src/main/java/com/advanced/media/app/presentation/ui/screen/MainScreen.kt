package com.advanced.media.app.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen (
    onItemSelected: (thumbnailId: Int) -> Unit,
    modifier: Modifier = Modifier
) {

}


@Preview
@Composable
fun PreviewHomeScreen() {
    MainScreen(
        onItemSelected = {}
    )
}
