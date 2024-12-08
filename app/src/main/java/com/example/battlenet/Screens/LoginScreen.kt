package com.example.battlenet.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.battlenet.Header
import com.example.battlenet.Body
import com.example.battlenet.Footer


@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF15171E)),
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(10.dp), contentAlignment = Alignment.TopCenter) {
            Header(Modifier.padding(5.dp))
        }

        Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
            Body(Modifier.padding(10.dp), LoginViewModel())
        }

        Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.BottomCenter) {
            Footer(Modifier.padding(10.dp))
        }
    }
}
