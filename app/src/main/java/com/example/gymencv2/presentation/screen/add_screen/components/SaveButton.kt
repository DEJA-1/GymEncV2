package com.example.gymencv2.presentation.screen.add_screen.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.screen.add_screen.addUser

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    onClickSave: () -> Unit = { }
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .clickable { onClickSave() },
        shape = RoundedCornerShape(30),
        color = AppColors.mDetails,
        contentColor = Color.White,
        elevation = 4.dp
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(1.0f)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "SAVE",
                textAlign = TextAlign.Center,
                fontSize = 52.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
