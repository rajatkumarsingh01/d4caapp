package com.example.d4capp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.d4capp.R

val OldStyle = FontFamily(
    Font(R.font.oldstyle, FontWeight.Normal),
    Font(R.font.oldstyle, FontWeight.Medium),
    Font(R.font.oldstyle, FontWeight.Bold)
)

val Tangerine = FontFamily(
    Font(R.font.tangerine, FontWeight.Normal),
    Font(R.font.tangerine, FontWeight.Medium),
    Font(R.font.tangerine, FontWeight.Bold)
)



val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = OldStyle,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle( // Tangerine applied here
        fontFamily = Tangerine,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    labelLarge = TextStyle( // Tangerine for some label
        fontFamily = Tangerine,
        fontSize = 14.sp
    ),

    labelMedium = TextStyle( // OldStyle
        fontFamily = Tangerine,
        fontSize = 12.sp
    )


//    titleLarge = TextStyle(
//        fontFamily = Tangerine,
//        fontWeight = FontWeight.Bold,
//        fontSize = 20.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = Tangerine,
//        fontSize = 12.sp
//    )
//    ,
//    headlineLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 32.sp,
//        lineHeight = 40.sp
//    ),
//    headlineMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 24.sp,
//        lineHeight = 32.sp
//    ),
//    titleLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 20.sp,
//        lineHeight = 28.sp
//    ),
//    titleMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 16.sp,
//        lineHeight = 24.sp
//    ),
//
//    bodyMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Normal,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 12.sp,
//        lineHeight = 16.sp
//    ),
//    labelSmall = TextStyle( // For overlines or tags
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Medium,
//        fontSize = 10.sp,
//        lineHeight = 14.sp
//    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)