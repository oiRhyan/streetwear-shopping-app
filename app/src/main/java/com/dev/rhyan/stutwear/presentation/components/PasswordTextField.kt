package com.dev.rhyan.stutwear.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.rhyan.stutwear.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PasswordTextField(
    text: MutableState<String>
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = {  },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 16.sp),
        singleLine = true,
        shape = RoundedCornerShape(60.dp),
        colors = TextFieldDefaults.colors(
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            disabledIndicatorColor = Color.White,
            errorIndicatorColor = Color.White
        ),
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(15.dp))
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = Color.White,
                    painter = painterResource(R.drawable.password),
                    contentDescription = "Password icon",
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        },
        trailingIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp).clickable{
                            passwordVisibility = !passwordVisibility
                        },
                        painter = if (passwordVisibility) painterResource(R.drawable.glasses2fill) else painterResource(R.drawable.glasses2line),
                        contentDescription = if (passwordVisibility) "Ocultar senha" else "Mostrar senha",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                }
        }
    )
}