package com.example.gymencv2.presentation.screen.add_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.presentation.common_components.MyTopBar
import com.example.gymencv2.presentation.screen.add_screen.components.InputTextField

@Composable
fun AddScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        Column {

            MyTopBar(navController = navController)

            Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {

                Column() {

                    InputTextField(label = "MUSCLE GROUP" )
                    InputTextField(label = "NAME" )
                    InputTextField(label = "DESCRIPTION" )

                }


            }

        }


    }

}