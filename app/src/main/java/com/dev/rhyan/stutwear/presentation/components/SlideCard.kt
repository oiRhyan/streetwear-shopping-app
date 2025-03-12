package com.dev.rhyan.stutwear.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.rhyan.stutwear.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WormIndicator(
    modifier: Modifier = Modifier,
    noOfDots: Int = 5,
    activeDotColor: Color = Color.Black,
    inActiveDotColor: Color = Color.Gray,
    spacedBy: Dp = 10.dp,
    dotSize: Dp = 15.dp,
    pagerState: PagerState
) {
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalArrangement = Arrangement
                .spacedBy(spacedBy),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(noOfDots) {
                Box(
                    modifier = Modifier
                        .size(dotSize)
                        .background(
                            color = inActiveDotColor,
                            shape = CircleShape
                        )
                )
            }
        }

        Box(
            Modifier
                .wormTransition(
                    indicatorColor = activeDotColor,
                    pagerState = pagerState
                )
                .size(dotSize)
                .clip(
                    shape = CircleShape,
                )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.wormTransition(
    indicatorColor: Color = Color.White,
    pagerState: PagerState
) =
    drawBehind {
        val distance = size.width + 10.dp.roundToPx()
        val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
        val wormOffset = (scrollPosition % 1) * 2

        val xPos = scrollPosition.toInt() * distance
        val head = xPos + distance * 0f.coerceAtLeast(wormOffset - 1)
        val tail = xPos + size.width + 1f.coerceAtMost(wormOffset) * distance

        val worm = RoundRect(
            head, 0f, tail, size.height,
            CornerRadius(50f)
        )

        val path = Path().apply {
            addRoundRect(worm)
        }
        drawPath(path = path, color = indicatorColor)
    }