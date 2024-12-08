package com.example.battlenet

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Footer(modifier: Modifier) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(bottom = 15.dp)
    ) {
        Text(
            text = "Crear una cuenta Battle.net gratis",
            color = Color(0xFF0074E0),
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://account.battle.net/creation/flow/creation-full"))
                context.startActivity(intent)
            },
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "¿No puedes iniciar sesión?",
            color = Color(0xFF0074E0),
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://account.battle.net/recovery/es/?theme=bnet-next&flowTrackingId=f15ea848-17bb-4955-b392-473e2e354f18&continuation-type=DOWNLOAD_PHOENIX"))
                context.startActivity(intent)
            },
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Política de privacidad",
            color = Color(0xFF0074E0),
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.blizzard.com/es-es/privacy"))
                context.startActivity(intent)
            },
            fontWeight = FontWeight.Bold
        )
    }
}