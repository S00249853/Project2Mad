package com.example.project2mad

import android.annotation.SuppressLint
import android.icu.text.CaseMap
import android.net.http.HeaderBlock
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project2madapp.ContactScreen
import com.example.project2madapp.CreateEditScreen
import com.example.project2madapp.ScheduleScreen
import com.example.project2madapp.TaskScreen
import com.example.project2madapp.TasksScreen
import com.example.project2madapp.ui.theme.Project2MadAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
val navController = rememberNavController()
            Scaffold(
                topBar = {TopUi("Daniel")},
                content = {Navigation(navController)},
                bottomBar = {
                    BottomNavigationUi(navController)
                }

            )




                }
            }



}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "tasks"){
        composable("home"){
              HomeScreen()
        }
        composable("tasks"){
            TasksScreen()
        }
        composable("schedule"){
            ScheduleScreen()
        }
        composable("contact"){
            ContactScreen()
        }
        composable("task"){
        //    TaskScreen()
        }
        composable("create"){
        //    CreateEditScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    Project2MadAppTheme()  {
        Scaffold(
            topBar = {TopUi("Daniel")},
            content = {Navigation(navController)},
            bottomBar = {
                BottomNavigationUi(navController)
            }

        )
    }
}