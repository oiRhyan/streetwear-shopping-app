package com.dev.rhyan.stutwear.presentation.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(
            Color(0xFF161616)
        )
    ) {
        Text("ProfileScreen", color = Color.White)
    }
}