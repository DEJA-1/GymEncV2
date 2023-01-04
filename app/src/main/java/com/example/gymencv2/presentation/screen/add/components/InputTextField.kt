package com.example.gymencv2.presentation.screen.add.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.gymencv2.common.AppColors

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String = "Text",
    maxLines: Int = 1,
    fontSize: TextUnit = 32.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    enabled: Boolean = true,
    onImeAction: () -> Unit = {},
    onTextChanged: (String) -> Unit = {}
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(value = text,
        onValueChange = onTextChanged,
        modifier = modifier,
        label = { Text(label) },
        maxLines = maxLines,
        enabled = enabled,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontStyle = fontStyle, fontSize = fontSize),
        colors = TextFieldDefaults.textFieldColors(textColor = Color.White,
        backgroundColor = Color.Transparent,
        unfocusedLabelColor = AppColors.mDetails,
        focusedLabelColor = AppColors.mDetails,
        focusedIndicatorColor = AppColors.mMain,
        unfocusedIndicatorColor = AppColors.mMain,
        cursorColor = AppColors.mDetails),
    )
}