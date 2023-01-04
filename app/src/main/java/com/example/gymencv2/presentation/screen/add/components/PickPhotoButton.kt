package com.example.gymencv2.presentation.screen.add.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymencv2.common.AppColors

@Composable
fun PickPhotoButton(modifier: Modifier = Modifier,
onClick: () -> Unit) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onClick() },
        color = AppColors.mMain,
        elevation = 4.dp,
        contentColor = Color.White,
        shape = RoundedCornerShape(42)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(1.0f)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "PICK A PHOTO",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
