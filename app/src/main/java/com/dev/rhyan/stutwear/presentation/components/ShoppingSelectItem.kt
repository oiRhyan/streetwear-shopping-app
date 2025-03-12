package com.dev.rhyan.stutwear.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.rhyan.stutwear.R

fun Modifier.noRippleEffect(
    onClick: () -> Unit
)  = composed {
    this.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = onClick
    )
}

data class TabItem(
    val title: String,
    val unselectedIcon: Int,
    val selectedIcon: Int
)


@Composable
fun CustomCircularTabLayout(
    modifier: Modifier,
    tabItems: List<TabItem>,
    selectedTabIndex: Int,
    containerColor: Color = Color.Transparent,
    selectedTabColor: Color = Color.White,
    unSelectedTabColor: Color = Color(0xFF222222),
    tabShape: Shape = CircleShape,
    iconSize: Dp = 24.dp,
    circleSize: Dp = 60.dp,
    indicatorHeight: Dp = 6.dp,
    onClick: (selectedIndex: Int) -> Unit
) {
    TabRow(
        divider = {},
        modifier = modifier,
        containerColor = containerColor,
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Transparent,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                SecondaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                    height = indicatorHeight,
                    color = selectedTabColor
                )
            }
        }) {
        tabItems.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .clip(tabShape)
                    .noRippleEffect {
                        onClick(index)
                    }
                    .background(Color.Transparent)
                    .padding(bottom = 22.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(circleSize)
                        .background(
                            color = if (selectedTabIndex == index) {
                                selectedTabColor
                            } else {
                                unSelectedTabColor
                            },
                            shape = tabShape
                        )
                        .clip(tabShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.size(iconSize),
                        painter = painterResource(
                            if (index == selectedTabIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            }
                        ),
                        contentDescription = "Tab Icon",
                    )
                }
            }
        }
    }
}

val icons = listOf<TabItem>(
    TabItem(
        selectedIcon = R.drawable.nike,
        unselectedIcon = R.drawable.nike_white,
        title = "Nike"
    ),
    TabItem(
        selectedIcon = R.drawable.adidas,
        unselectedIcon = R.drawable.adidaswhite,
        title = "Nike"
    ),
    TabItem(
        selectedIcon = R.drawable.palace,
        unselectedIcon = R.drawable.palacewhite,
        title = "Nike"
    ),
    TabItem(
        selectedIcon = R.drawable.supreme_black,
        unselectedIcon = R.drawable.supreme_white,
        title = "Nike"
    ),
    TabItem(
        selectedIcon = R.drawable.northblack,
        unselectedIcon = R.drawable.northwhite,
        title = "Nike"
    ),
)

@Preview(showBackground = true)
@Composable
fun CustomTabLayoutCircularDemo() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    CustomCircularTabLayout(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        tabItems = icons,
        selectedTabIndex = selectedTabIndex
    ) {
        selectedTabIndex = it
    }
}