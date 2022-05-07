package com.irfan.onboardingcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.irfan.onboardingcompose.R

val circularStd = FontFamily(
    listOf(
        Font(R.font.circular_std, FontWeight.Normal)
    )
)

val avenir = FontFamily(
    listOf(
        Font(R.font.avenir_book)
    )
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = avenir,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    button = TextStyle(
        fontFamily = circularStd,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    )
)