package com.wkt.distriware.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController, onButtonClick: () -> Unit) {
    TitleBar("Distriware")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            IconButton(onClick = { /* Handle icon button click */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

//@Preview(showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    MenuScreen()
//}