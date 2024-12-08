package com.example.battlenet

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@Composable
fun Header(modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Logo Battlenet
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.Center)
                .size(215.dp)
        )

        // Iconos en la esquina superior derecha
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Minimizar app",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { activity.moveTaskToBack(true) },
                tint = Color(0xFF808185)
            )
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cerrar app",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { activity.finish() },
                tint = Color(0xFF808185)
            )
        }
    }
}