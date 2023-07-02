package com.wkt.distriware.ui.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingScreen(onclick: (String, String) -> Unit) {

    val settingViewModel: SettingViewModel = viewModel()
    val serverAddress = settingViewModel.serverAddress.collectAsState()
    val port = settingViewModel.port.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Server")
            Text(text = serverAddress.value.toString(), Modifier.clickable {
                onclick("Server", serverAddress.value.toString())
            })
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Port")
            Text(text = port.value.toString(), modifier = Modifier.clickable {
                onclick("Port", port.value.toString())
            })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    SettingScreen { _, _ ->
        // Handle the parameters
    }
}