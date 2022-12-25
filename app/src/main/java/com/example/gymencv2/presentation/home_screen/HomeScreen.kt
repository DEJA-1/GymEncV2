package com.example.gymencv2.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.home_screen.components.Header
import com.example.gymencv2.presentation.home_screen.components.MyTopBar

@Preview
@Composable
fun HomeScreen() {

    Surface(modifier = Modifier.fillMaxSize(),
    color = AppColors.mBackground) {

        Column() {
            MyTopBar()
            Header()

        }

    }

}