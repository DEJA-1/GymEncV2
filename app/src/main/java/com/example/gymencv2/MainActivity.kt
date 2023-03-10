package com.example.gymencv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gymencv2.navigation.SetupNavGraph
import com.example.gymencv2.presentation.viewmodel.ExerciseViewModel
import com.example.gymencv2.ui.theme.GymEncV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymEncV2Theme {
                // A surface container using the 'background' color from the theme

                navController = rememberNavController()
                val viewModel = hiltViewModel<ExerciseViewModel>()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetupNavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}
