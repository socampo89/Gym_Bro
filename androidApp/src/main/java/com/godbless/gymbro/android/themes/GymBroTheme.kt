package com.godbless.gymbro.android.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.godbless.gymbro.android.R

private val light = Font(R.font.roboto_condensed_light, FontWeight.W300)
private val regular = Font(R.font.roboto_condensed_regular, FontWeight.W400)
private val semibold = Font(R.font.roboto_condensed_bold, FontWeight.W600)
private val bold = Font(R.font.roboto_condensed_bold, FontWeight.Bold)
private val italic = Font(R.font.roboto_condensed_italic, FontWeight.Normal)
private val italic_light = Font(R.font.roboto_condensed_light_italic, FontWeight.W300)
private val italic_bold = Font(R.font.roboto_condensed_bold_italic, FontWeight.W300)
private val robotoFontFamily = FontFamily(light, regular, bold, semibold, italic, italic_light, italic_bold)

@Composable
fun GymBroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            secondary = Color(0xFF03DAC5)
        )
    }
    val typography = Typography(
        defaultFontFamily = robotoFontFamily,
        body1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )

    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}