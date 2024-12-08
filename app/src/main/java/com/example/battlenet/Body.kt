package com.example.battlenet

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType
import com.example.battlenet.Screens.LoginViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun Body (modifier: Modifier, loginViewModel:LoginViewModel){

    val email:String by loginViewModel.email.observeAsState(initial = "")
    val password:String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

    // Orden
    Column (modifier = modifier) {
        Configuration()
        Spacer(modifier = Modifier.size(16.dp))
        Email(modifier.align(Alignment.CenterHorizontally), email) {loginViewModel.onLoginChanged(email = it, password=password)}
        Spacer(modifier = Modifier.size(16.dp))
        Password(password) { loginViewModel.onLoginChanged(email = email, password = it)}
        Spacer(modifier = Modifier.size(4.dp))
        Nocerrarsesion()
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(16.dp))
        SocialLogin()
    }
}

// Rueda de settings
@Composable
fun Configuration() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, top = 50.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Configuración",
            modifier = Modifier.padding(start = 8.dp),
            tint = Color(0xFF696B6F)
        )
    }
}

// Campo de texto para email
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(modifier: Modifier, email: String, onTextChanged: (String) -> Unit) {

    val focusRequester = FocusRequester() // Para saber si el campo está seleccionado
    val isFocused = remember { mutableStateOf(false) } // Recuerda si está o no seleccionado

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                // Cambiamos de color los bordes del campo de texto seleccionado
                color = if (isFocused.value) Color(0xFF0074E0) else Color(0xFF696B6F),
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        TextField(
            value = email,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged { focusState -> isFocused.value = focusState.isFocused },
            placeholder = {
                Text(
                    text = "Correo electrónico o número de teléfono",
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFFB2B2B2),
                unfocusedTextColor = Color(0xFFB2B2B2),
                containerColor = Color(0xFF15171E)
            ),
            textStyle = TextStyle(fontSize = 14.sp),
        )
    }
}


// Campo de texto para contraseña
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val focusRequester = FocusRequester()
    val isFocused = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = if (isFocused.value) Color(0xFF0074E0) else Color(0xFF696B6F),
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        TextField(
            value = password,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged { focusState -> isFocused.value = focusState.isFocused },
            placeholder = {
                Text(
                    text = "Correo electrónico o número de teléfono",
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color(0xFFB2B2B2),
                unfocusedTextColor = Color(0xFFB2B2B2),
                containerColor = Color(0xFF15171E)
            ),
            textStyle = TextStyle(fontSize = 14.sp),
            // TrailingIcon es el icono que nos va a permitir hacer o no visible la contraseña
            trailingIcon = {
                val imagen = if (passwordVisibility) {
                    Icons.Filled.Clear
                } else {
                    Icons.Filled.Done
                }
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = imagen, contentDescription = "show password")
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )
    }
}

// Checkbox de no cerrar sesión
@Composable
fun Nocerrarsesion() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        // Checkbox
        var isChecked by remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF0074E0),
                uncheckedColor = Color(0xFF696B6F)
            )
        )

        Text(
            text = "No cerrar sesión",
            color = Color(0xFF85868a),
            modifier = Modifier.padding(start = 8.dp),
            style = TextStyle(fontSize = 14.sp)
        )

        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Información",
            modifier = Modifier.padding(start = 8.dp),
            tint = Color(0xFF696B6F)
        )
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = {},
        enabled = loginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .height(45.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0074E0),
            disabledContainerColor = Color(0xFF0074E0),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    )
    {
        Text(
            text = "Iniciar Sesión",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// Líneas divisorias
@Composable
fun LoginDivider(){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        HorizontalDivider(
            Modifier
                .background(Color(0xFF85868a))
                .height(0.5.dp)
                .weight(1f)
        )
        Text( // Texto intermedio
            text = "o continúa con",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF85868a)
        )
        HorizontalDivider(
            Modifier
                .background(Color(0xFF85868a))
                .height(0.5.dp)
                .weight(1f)
        )
    }
}

// Iconos de redes sociales
@Composable
fun SocialLogin() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(48.dp)
                    // Hacemos que nos lleve a una url al clickarlos con la implementación de intent
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signup"))
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Apple",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"))
                        context.startActivity(intent)
                    }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.xbox),
                contentDescription = "Xbox",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.xbox.com"))
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.playstation),
                contentDescription = "Playstation",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.playstation.com"))
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.nintendo),
                contentDescription = "Switch",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nintendo.com"))
                        context.startActivity(intent)
                    }
            )
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = R.drawable.steam),
                contentDescription = "Steam",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://store.steampowered.com"))
                        context.startActivity(intent)
                    }
            )
        }
    }
}