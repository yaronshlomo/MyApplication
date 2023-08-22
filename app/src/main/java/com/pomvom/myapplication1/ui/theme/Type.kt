package com.pomvom.pomvompro.main.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pomvom.myapplication1.R

val myCustomFont = FontFamily(
    Font(R.font.inter, weight = FontWeight.Normal, loadingStrategy = FontLoadingStrategy.Async), Font(R.font.inter_bold, weight = FontWeight.Bold, loadingStrategy = FontLoadingStrategy.Async),
    Font(R.font.inter_medium, weight = FontWeight.Medium, loadingStrategy = FontLoadingStrategy.Async),
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold, loadingStrategy = FontLoadingStrategy.Async),
    Font(R.font.inter_extrabold, weight = FontWeight.ExtraBold, loadingStrategy = FontLoadingStrategy.Async), Font(R.font.inter_thin, weight = FontWeight.Thin, loadingStrategy = FontLoadingStrategy.Async), Font(R.font.inter_extralight, weight = FontWeight.ExtraLight,  loadingStrategy = FontLoadingStrategy.Async),
    Font(R.font.inter_light, weight = FontWeight.Light, loadingStrategy = FontLoadingStrategy.Async), Font(R.font.inter_black, weight = FontWeight.Black, loadingStrategy = FontLoadingStrategy.Async),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = myCustomFont,
    body1 = TextStyle(fontFamily = myCustomFont, fontWeight = FontWeight.Normal, fontSize = 20.sp),
    h1 = TextStyle(fontFamily = myCustomFont, fontWeight = FontWeight.Normal, fontSize = 30.sp),
    h2 = TextStyle(fontFamily = myCustomFont, fontWeight = FontWeight.Normal, fontSize = 28.sp),
    h3 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 24.sp),
    h4 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 24.sp),
    h5 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 24.sp),
    h6 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 20.sp),
    subtitle1 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
    subtitle2 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
    body2 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
    button = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
    caption = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
    overline = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp),
)