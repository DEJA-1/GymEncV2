package com.example.gymencv2.presentation.common_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors

@Composable
fun MyTopBar(navController: NavController, modifier: Modifier = Modifier) {

    TopAppBar(modifier = modifier,
        backgroundColor = Color.Transparent,
        contentColor = AppColors.mDetails,
        elevation = 0.dp) {

        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
            modifier = Modifier.clickable {
                navController.popBackStack()
            })

    }

}