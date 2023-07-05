package com.wkt.distriware.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wkt.distriware.ui.setting.SettingViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DialogScreen(navController: NavController, fieldName: String, fieldValue: String) {

    val settingViewModel: SettingViewModel = hiltViewModel()

    val showDialog = remember { mutableStateOf(false) }
    val textValue = remember { mutableStateOf(TextFieldValue(fieldValue)) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(showDialog.value) {
        if (showDialog.value) {
            keyboardController?.show()
            delay(50)
            focusRequester.requestFocus()
        }
    }

    // Trigger the flag to indicate that the composable has been rendered
    DisposableEffect(Unit) {
        showDialog.value = true
        onDispose {
            showDialog.value = false
        }
    }

    AlertDialog(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        onDismissRequest = {
            showDialog.value = false
        },
        title = {
            Text(text = "Enter $fieldName")
        },
        text = {
            TextField(
                value = textValue.value,
                onValueChange = { newText ->
                    textValue.value = newText
                },
                placeholder = { Text(text = "000.000.000.000") },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .onFocusEvent {  Log.d("OBSERVE_FOCUS_CHANGED", "onFocusEvent") }
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            textValue.value = textValue.value.copy(selection = TextRange(0, textValue.value.text.length))
                        }
                    },
            )
        },
        confirmButton = {
            Button(onClick = {
                showDialog.value = false
                settingViewModel.saveConfigSetting(fieldName, textValue.value.text)
                navController.popBackStack()
            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = {
                showDialog.value = false
                navController.popBackStack()
            }) {
                Text(text = "Dismiss")
            }
        }
    )
}