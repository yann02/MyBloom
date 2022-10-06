package com.yyw.bloom.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.yyw.bloom.R

val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(R.font.nunitosans_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontSize = 18.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontSize = 14.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Bold,
        letterSpacing = .15.sp
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    subtitle2 = TextStyle(
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    body2 = TextStyle(
        fontSize = 12.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.Light
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontFamily = nunitoSansFamily,
        fontWeight = FontWeight.SemiBold
    )
)