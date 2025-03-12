package com.dev.rhyan.stutwear.presentation.ui

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.gif.AnimatedImageDecoder
import coil3.gif.GifDecoder
import com.dev.rhyan.stutwear.R
import com.dev.rhyan.stutwear.presentation.components.PasswordTextField
import com.dev.rhyan.stutwear.presentation.theme.backgroundColor

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreenTest() {

    val text = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(AnimatedImageDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Column(
        modifier = Modifier.fillMaxSize().background(
            Color(0xFF161616)
        )
    ) {
        Box(
           modifier = Modifier.height(400.dp)
        ) {
            Box(

            ) {
                Card(
                    shape = RoundedCornerShape(
                        bottomEnd = 150.dp,
                    ),
                    modifier = Modifier.fillMaxWidth().height(380.dp)
                ) {
                    AsyncImage(
                        model = R.drawable.midiaanimation,
                        contentDescription = "Animation GIF",
                        imageLoader = imageLoader,
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(
                            color = Color.Black.copy(alpha = 0.5f),
                            blendMode = BlendMode.Multiply
                        )
                    )
                }
                Box(

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 70.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.size(260.dp),
                            painter = painterResource(R.drawable.text_logo),
                            contentDescription = "App Logo"
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp),
            horizontalAlignment = Alignment.Start
        ) {
            OutlinedTextField(
                value = text.value,
                label = { Text(text = "") },
                onValueChange = { text.value = it },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                ),
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            modifier = Modifier.size(24.dp),
                            tint = Color.White,
                            painter = painterResource(R.drawable.email),
                            contentDescription = "Email icon",
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "ex: stat@email.com",
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            PasswordTextField(password)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color.Black,
                        checkedColor = Color.White
                    )
                )
                Text(
                    text = "Lembrar senha",
                    color = Color.White,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp, top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5D65BC)
                    ),
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text(
                        text = "ENTRAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Ainda não possuí uma conta?", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Registrar", color = Color.Magenta)
            }
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.login_with_google),
                    contentDescription = "Login With Google Button",
                    modifier = Modifier.height(60.dp).width(200.dp).clickable {

                    }
                )
            }
        }
    }
}