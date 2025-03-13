package com.dev.rhyan.stutwear.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.dev.rhyan.stutwear.R
import com.dev.rhyan.stutwear.data.models.response.Product


@Composable
fun ShoesCardItem(product  : Product) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 9.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF222222)
        ),
        modifier = Modifier
            .width(180.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            ShowItemImage(product.image.toString())
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${product.title}",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.White
            )
            Text(
                text = "${product.min_price}",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(1.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${product.avg_price}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 8.dp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                FilledIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.filledIconButtonColors(Color.Black, Color.White),
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        modifier = Modifier.padding(6.dp)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                FilledIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.filledIconButtonColors(Color.Black, Color.White),
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Add to Cart",
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ShowItemImage(image : String) {
    AsyncImage(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .size(190.dp, 98.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(10.dp),
        model = image,
        contentDescription = "Imagem do Tênis",
        contentScale = ContentScale.FillWidth
    )
}
