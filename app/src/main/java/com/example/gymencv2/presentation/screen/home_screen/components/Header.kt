package com.example.gymencv2.presentation.screen.home_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymencv2.common.AppColors

@Composable
fun Header(modifier: Modifier = Modifier) {

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(top = 62.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        color = AppColors.mBackground,
    ) {

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
        ) {

            val annotatedString = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    fontSize = 84.sp)
                ) {
                    append("GYM")
                }

                withStyle(
                    SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.mDetails,
                    fontSize = 62.sp)
                ) {
                    append("ENC")
                }
            }

            Text(text = annotatedString)

        }

    }

}