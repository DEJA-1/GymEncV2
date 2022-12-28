package com.example.gymencv2.presentation.sample_exercises_screen.components

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
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.navigation.Screen

@Composable
fun UserExercisesButton(navController: NavController) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
            .clickable {
                       onClick(navController)
            },
        shape = RoundedCornerShape(16.dp),
        color = AppColors.mDetails,
        elevation = 4.dp
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(1.0f)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "YOUR EXERCISES",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

    }

}

fun onClick(navController: NavController) {
    navController.navigate(route = Screen.UserExercises.route)
}