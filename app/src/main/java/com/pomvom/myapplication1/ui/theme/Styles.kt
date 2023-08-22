package com.pomvom.pomvompro.main.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.pomvom.pomvomscan.ui.theme.GreenText
import com.pomvom.pomvomscan.ui.theme.Red
import com.pomvom.pomvomscan.ui.theme.SettingsDescriptionTextColor

val settingsSmallTitleStyle = TextStyle(
    color = Color.Black,
    fontSize = 18.sp,
    fontWeight = FontWeight.Normal,
    background = Color.Transparent,
)

val settingsTitleStyle = TextStyle(
    color = Color.Black,
    fontSize = 19.sp,
    fontWeight = FontWeight.Bold,
    background = Color.Transparent,
)

val settingsDescriptionStyle = TextStyle(
    color = SettingsDescriptionTextColor,
    fontSize = 17.sp,
    fontWeight = FontWeight.Light,
    background = Color.Transparent,
)

val mainScreenRedStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    color = Red,
    fontSize = 14.sp,
)

val mainScreenBlackStyle = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
)

val mainScreenGreenStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    color = GreenText,
    fontSize = 14.sp,
)

val statusTitleStyle = TextStyle(
    color = Color.Black,
    fontSize = 18.sp,
    fontWeight = FontWeight.Normal
)

val statusPhotosStyle = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal
)

val statusCounterStyle = TextStyle(
    color = Color.Black,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold
)

val fullImageDetailsTitleStyle = TextStyle(
    color = Color.Black,
    fontSize = 12.sp,
    fontWeight = FontWeight.Light
)

val fullImageDetailsValueStyle = TextStyle(
    color = Color.Black,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold
)

@OptIn(ExperimentalUnitApi::class)
val passwordEditTextStyle = TextStyle(
    color = Color.Black,
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium,
    lineHeight = TextUnit(0.5f, TextUnitType.Sp)
)

val permissionAnnotatedTextStyle = TextStyle(
    color = Color.White,
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium
)