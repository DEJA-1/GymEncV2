package com.example.gymencv2.presentation.screen.add_screen

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import com.example.gymencv2.common.AppColors
import com.example.gymencv2.domain.model.Exercise
import com.example.gymencv2.navigation.Screen
import com.example.gymencv2.presentation.common_components.MyTopBar
import com.example.gymencv2.presentation.screen.add_screen.components.InputTextField
import com.example.gymencv2.presentation.screen.add_screen.components.PickPhotoButton
import com.example.gymencv2.presentation.screen.add_screen.components.SaveButton
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel

@Composable
fun AddScreen(navController: NavController, muscleGroup: String, viewModel: ExerciseViewModel) {

    var name by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var selectedImageUri by remember {
        mutableStateOf("")
    }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri.toString()}
    )

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.mBackground
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(6.dp)
        ) {

            MyTopBar(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp)
            )

            InputTextField(
                text = muscleGroup.uppercase(),
                label = "MUSCLE GROUP",
                enabled = false,
                fontStyle = FontStyle.Italic
            )

            InputTextField(
                text = name.uppercase(),
                label = "NAME",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })
                        name = it
                })

            InputTextField(
                text = description.uppercase(),
                label = "DESCRIPTION",
                maxLines = 5,
                fontSize = 16.sp,
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })
                        description = it
                }
            )

            PickPhotoButton(modifier = Modifier.padding(32.dp)) {
                photoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
                Log.d("tEST", selectedImageUri)
            }

            SaveButton(modifier = Modifier.padding(start = 26.dp, end = 26.dp)) {

                if (!inputCheck(name, description, selectedImageUri)) {
                    addUser(muscleGroup, name, description, selectedImageUri, viewModel)
                    name = ""
                    description = ""
                    selectedImageUri = ""
                    navController.navigate(route = Screen.UserExercises.route)
                } else {
                    Toast.makeText(context, "Fill out the data!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}

fun addUser(muscleGroup: String, name: String, description: String, selectedImage: String, viewModel: ExerciseViewModel) {

    val exercise: Exercise = Exercise(muscle = muscleGroup, name = name, description = description, image = selectedImage)

    viewModel.insertExerciseToDb(exercise)
}

fun inputCheck(name: String, description: String, selectedImage: String) : Boolean {
    if (name.isEmpty() || description.isEmpty() || selectedImage.isEmpty())
        return true

    return false
}