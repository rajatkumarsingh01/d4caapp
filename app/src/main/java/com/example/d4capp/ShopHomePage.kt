package com.example.d4capp

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.example.d4capp.ui.theme.OldStyle
import com.example.d4capp.ui.theme.Tangerine

@Composable
fun ShopHomePage() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .verticalScroll(scrollState)
    ) {

        TopBar()
        PromotionBanner()
        CategorySection()
        NewProductsSection()
    }
}

@Composable
fun TopBar(
    favoriteCount: Int = 5,
    cartCount: Int = 3
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left: Back arrow + Shop
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Shop",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        // Right: Search, Favorite (with badge), Cart (with badge)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            IconWithBadge(
                icon = Icons.Default.FavoriteBorder,
                badgeCount = favoriteCount
            )

            Spacer(modifier = Modifier.width(16.dp))

            IconWithBadge(
                icon = Icons.Default.ShoppingCart,
                badgeCount = cartCount
            )
        }
    }
}

@Composable
fun IconWithBadge(
    icon: ImageVector,
    badgeCount: Int
) {
    Box {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        if (badgeCount > 0) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 8.dp, y = (-4).dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}



@Composable
fun PromotionBanner() {
    Box(
        modifier = Modifier
            .height(190.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_card),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 24.dp, end = 24.dp)
        ) {
            Text(
                text = "GET 20% OFF",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Get 20% off",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left: Date pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFFB4FF39))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "12–16 October",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Right: Image icon (placeholder)
                Icon(
                    painter = painterResource(id = R.drawable.rollup), // use outlined image icon here
                    contentDescription = "Placeholder",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        // Bottom Indicator Bar (outside content column)
        Row(
            modifier = Modifier
                .padding(start = 60.dp, top = 20.dp, bottom = 6.dp)
                .align(Alignment.BottomStart),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val indicators = listOf(true, false, false)
            indicators.forEachIndexed { index, isSelected ->
                Box(
                    modifier = Modifier
                        .width(if (isSelected) 24.dp else 16.dp)
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(if (isSelected) Color(0xFFB4FF39) else Color.Black)
                )
                if (index != indicators.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}


@Composable
fun CategorySection() {
    val categories = listOf(
        "Cleaners" to R.drawable.categorysample,
        "Toner" to R.drawable.productimage,
        "Serums" to R.drawable.categorysample,
        "Moisturisers" to R.drawable.productimage,
        "Sunscreens" to R.drawable.categorysample,
        "Moisturisers" to R.drawable.productimage,
        "Sunscreens" to R.drawable.categorysample
    )

    Column(modifier = Modifier.padding(start = 16.dp, top = 8.dp)) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = OldStyle,
                color = Color.White
            )
        )

        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(end = 16.dp)
        ) {
            items(categories) { (name, imageRes) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = name,
                        style = MaterialTheme.typography.labelMedium.copy(color = Color.White)
                    )
                }
            }
        }
    }
}


@Composable
fun NewProductsSection() {
    Column(modifier = Modifier
        .fillMaxWidth()
        ) {
        Text("New Products", style = MaterialTheme.typography.titleLarge.copy(color = Color.White), fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier)
        ProductItem(
            name = "Clencera",
            price = "Rs. 355.20",
            originalPrice = "Rs. 444.00",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehydrated Skin",
            imageRes = painterResource(id = R.drawable.productimage),
            inStock = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProductItem(
            name = "Glow",
            price = "Rs. 355.20",
            originalPrice = "Rs. 444.00",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehydrated Skin",
            imageRes = painterResource(id = R.drawable.categorysample),
            inStock = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProductItem(
            name = "Serum",
            price = "Rs. 355.20",
            originalPrice = "Rs. 444.00",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehydrated Skin",
            imageRes = painterResource(id = R.drawable.productimage),
            inStock = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProductItem(
            name = "Glow",
            price = "Rs. 355.20",
            originalPrice = "Rs. 444.00",
            description = "French clay and algae-powered cleanser\nSkin Tightness • Dry & Dehydrated Skin",
            imageRes = painterResource(id = R.drawable.categorysample),
            inStock = true
        )
    }
}

@Composable
fun ProductItem(
    name: String,
    price: String,
    originalPrice: String,
    description: String,
    imageRes: Painter,
    inStock: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(30.dp))
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.grey_card_svg), // Your drawable SVG
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(30.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            // Header row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color(0xFFE0B0FF),
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .size(24.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color.Black)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        "Best seller",
                        color = Color(0xFFB4FF39),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Product image
            Image(
                painter = imageRes,
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Detail card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.product_title_card),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(30.dp))
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp) // padding for content inside the box
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            name,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontFamily = Tangerine,
                                color = Color(0xFFB4FF39)
                            )
                        )
                        if (inStock) {
                            Text("• In stock", color = Color(0xFFB4FF39), fontSize = 12.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        description,
                        color = Color.White,
                        fontSize = 12.sp
                    )

                    Text(
                        "Skin Tightness • Dry & Dehydrated Skin",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(price, color = Color(0xFFE0B0FF), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            originalPrice,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough),
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(5) {
                            Icon(
                                Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFC107),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "249 reviews",
                            color = Color.Gray,
                            fontSize = 12.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(start =16.dp, top = 10.dp, bottom = 14.dp) // padding so it doesn’t go out of bounds
                        .size(48.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFB4FF39),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Add to cart",
                        tint = Color(0xFFB4FF39),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

        }
    }
}
