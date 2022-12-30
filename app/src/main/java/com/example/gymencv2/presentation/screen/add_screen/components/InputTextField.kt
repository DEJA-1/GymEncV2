package com.example.gymencv2.presentation.screen.add_screen.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.gymencv2.common.AppColors

@Preview
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    label: String = "Text",
    maxLines: Int = 1
) {

    var text by remember { mutableStateOf("") }

    TextField(value = text,
        onValueChange = {
            text = it
        },
        modifier = modifier,
        label = { Text(label) },
        maxLines = maxLines,
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontStyle = Italic, fontSize = 32.sp),
        colors = TextFieldDefaults.textFieldColors(textColor = Color.White,
        backgroundColor = Color.Transparent,
        unfocusedLabelColor = AppColors.mDetails,
        focusedLabelColor = AppColors.mDetails,
        focusedIndicatorColor = AppColors.mMain,
        unfocusedIndicatorColor = AppColors.mMain),

    )
}