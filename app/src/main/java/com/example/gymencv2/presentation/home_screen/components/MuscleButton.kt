package com.example.gymencv2.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymencv2.R
import com.example.gymencv2.common.AppColors

@Composable
fun MuscleButton(
    modifier: Modifier = Modifier,
    icon: Int,
    muscleGroup: String,
    onClick: () -> Unit = {}
) {

    Surface(
        modifier = modifier
            .clickable {
                onClick()
            }
            .padding(8.dp)
            .height(120.dp),
        shape = RoundedCornerShape(8.dp),
        color = AppColors.mMain,
        elevation = 4.dp
    ) {

        Image(
            modifier = Modifier.padding(12.dp),
            painter = painterResource(id = icon), contentDescription = "Icon",
            colorFilter = ColorFilter.tint(AppColors.mDetails),
            contentScale = ContentScale.Inside
        )
    }

}