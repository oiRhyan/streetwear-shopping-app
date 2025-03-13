package com.dev.rhyan.stutwear.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.rhyan.stutwear.R


sealed class Screen(
    val title: String,
    val activeIcon: Int,
    val inactiveIcon: Int,
    val badgeCount: Int
) {

    data object Home :
        Screen("Home", R.drawable.home_fill, R.drawable.home_line, 0)

    data object Explore :
        Screen("Explore", R.drawable.global_fill, R.drawable.global_line, 1)

    data object Data :
        Screen("Favorite", R.drawable.heart_fill, R.drawable.heart_line, 2)

    data object Profile :
        Screen("Profile", R.drawable.account_circle_fill, R.drawable.account_circle_line, 3)
}

val screen = listOf(
    Screen.Home,
    Screen.Explore,
    Screen.Data,
    Screen.Profile
)

@Composable
fun BottomNavigationBar(
    screens : List<Screen>,
    onScreenSelected : (String) -> Unit
) {
    var index by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier.width(300.dp).height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF222222).copy(0.5f)
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow {
                items(screens) { screen ->
                    Icon(
                        painterResource(
                            if(index == screen.badgeCount) screen.activeIcon else screen.inactiveIcon
                        ),
                        contentDescription = "Icon",
                        modifier = Modifier.size(55.dp).padding(12.dp).clickable {
                            index = screen.badgeCount
                            onScreenSelected(screen.title)
                        },
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview()
@Composable
fun showNavigation() {
    BottomNavigationBar(screens = screen, onScreenSelected = {})
}