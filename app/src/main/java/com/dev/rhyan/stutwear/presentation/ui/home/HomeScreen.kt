package com.dev.rhyan.stutwear.presentation.ui.home

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.dev.rhyan.stutwear.R
import com.dev.rhyan.stutwear.presentation.components.CustomTabLayoutCircularDemo
import com.dev.rhyan.stutwear.presentation.components.WormIndicator

@Composable
fun HomeScreen() {

    val pagerState = rememberPagerState(
        pageCount = { 5 }
    )

    Column(
        modifier = Modifier.fillMaxSize().background(
            Color(0xFF161616)
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 70.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier.size(50.dp),
                contentDescription = "Image Profile",
                model = R.drawable.ghots
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF222222)
                    ),
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        imageVector =  Icons.Default.Search,
                        contentDescription = "Shopping Button",
                        modifier = Modifier.size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF222222)
                    ),
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.shopping_bag),
                        contentDescription = "Searching Button",
                        modifier = Modifier.size(25.dp),
                        tint = Color.White
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(
                text = "Olá, Nome!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Confira nossas últimas novidades",
                color = Color.LightGray,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                pageSpacing = 12.dp,
                beyondViewportPageCount = 3,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) { page ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Card(
                        modifier = Modifier.height(200.dp).fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                    ) {
                        when(page) {
                            0 -> {
                                Image(
                                    painter = painterResource(id = R.drawable.jordan_james_banner),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            1 -> {
                                Image(
                                    painter = painterResource(id = R.drawable.air_max_shoe_banner),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            2 -> {
                                Image(
                                    painter = painterResource(id = R.drawable.antartica_banner),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            3 -> {
                                Image(
                                    painter = painterResource(id = R.drawable.nike_banner_shoe_basket),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            4 -> {
                                Image(
                                    painter = painterResource(id = R.drawable.first_banner),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            WormIndicator(
                modifier = Modifier,
                noOfDots = 5,
                activeDotColor = Color(0xFF5D65BC),
                inActiveDotColor = Color(0xFFD2D2D2),
                spacedBy = 10.dp,
                dotSize = 15.dp,
                pagerState = pagerState
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomTabLayoutCircularDemo()
    }

}
