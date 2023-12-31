package com.wkt.distriware.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.wkt.distriware.ui.compose.NavDestinations
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class
)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    onButtonClick: () -> Unit
) {

    val loginViewModel: LoginViewModel = viewModel()

    val username = loginViewModel.username.collectAsState()
    val password = loginViewModel.password.collectAsState()
    val isSuccess = loginViewModel.isSuccess.collectAsState(initial = false)

    val requestScrollUp = remember { BringIntoViewRequester() }

    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxWidth()){
        SnackbarHost(hostState = snackState, Modifier.align(Alignment.BottomCenter))
        Column(modifier = Modifier.fillMaxSize(),
        ) {

            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { onButtonClick() },
                    modifier = Modifier.padding(top = 16.dp,end = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Setting icon"
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = username.value,
                    label = { Text(text = "Username") },
                    onValueChange = loginViewModel::setUsername,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp, 20.dp, 0.dp)
                        .bringIntoViewRequester(requestScrollUp)
                )

                OutlinedTextField(
                    value = password.value,
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = loginViewModel::setPassword,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp)
                )

                Button(
                    onClick = {
                        loginViewModel.login()
                    },
                    enabled = loginViewModel.isLoginButtonEnabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 20.dp)

                ) {
                    Text(text = "Login")
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        loginViewModel.username.collect {
            loginViewModel.updateLoginButtonEnabled()
        }
    }

    LaunchedEffect(Unit) {
        loginViewModel.password.collect {
            loginViewModel.updateLoginButtonEnabled()
        }
    }

    LaunchedEffect(isSuccess.value) {
        if (isSuccess.value) {
            navHostController.navigate(NavDestinations.MenuScreen)
        }
    }

    LaunchedEffect(Unit) {
        loginViewModel.errorMessage.collectLatest { errorMessage ->
            errorMessage?.let { message ->
                snackScope.launch { snackState.showSnackbar(message) }
                loginViewModel.resetErrorMessage()
            }
        }
    }
}