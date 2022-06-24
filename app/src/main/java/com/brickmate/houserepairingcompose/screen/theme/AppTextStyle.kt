package com.brickmate.houserepairingcompose.screen.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalTextApi::class)
object AppTextStyle {

    val semiBold16 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val semiBold24Blue = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Green200,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val regular12 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val medium10 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val medium14 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val medium12 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )

    val medium16 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold20 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold24 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold16 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold14 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold8 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 8.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val bold10 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )


}
