package com.example.gymencv2.presentation.screen.user.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun UserExerciseRow(exercise: Exercise, viewModel: ExerciseViewModel) {

    val isExpanded = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                isExpanded.value = !isExpanded.value
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        backgroundColor = AppColors.mDetails
    ) {

        Column() {

            Row() {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(exercise.image)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Exercise image"
                )
            }

            AnimatedVisibility(visible = isExpanded.value) {

                Column() {
                    Text(modifier = Modifier.padding(12.dp),
                        text = exercise.name.uppercase(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )

                    Text(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
                        text = exercise.description.uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clickable { onClickDelete(exercise, viewModel) },
                        color = AppColors.mRed
                    ) {
                        Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center) {

                            Icon(imageVector = Icons.Rounded.Delete, contentDescription = "Delete Button")

                        }
                    }

                }

            }
        }
    }

}

fun onClickDelete(exercise: Exercise, viewModel: ExerciseViewModel) {
    viewModel.deleteExerciseFromDb(exercise)
}