package com.example.project2madapp

import android.annotation.SuppressLint
import android.icu.text.CaseMap
import android.net.http.HeaderBlock
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room

import com.example.project2madapp.ContactScreen
import com.example.project2madapp.CreateEditScreen
import com.example.project2madapp.ScheduleScreen
import com.example.project2madapp.TaskScreen
import com.example.project2madapp.TasksScreen
import com.example.project2madapp.ui.theme.Project2MadAppTheme

@Suppress("UNCHECKED_CAST")
public class MainActivity : ComponentActivity() {
private  val  db by lazy{
    Room.databaseBuilder(
        applicationContext,
        TaskDatabase::class.java,
        "tasks.db"
    ).build()
}
    private val viewModel by viewModels<TaskViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TaskViewModel(db.dao) as T
                }
            }
        }
    )

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state by viewModel.State.collectAsState()
val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationUi(navController)
                }
            )
            {
                Navigation(navController, state, viewModel::onEvent)
            }
                }
            }
}

@Composable
fun Navigation(navController: NavHostController,
               state: TaskState,
               onEvent: (TaskEvent) -> Unit){
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
              HomeScreen(state, onEvent, navController)
        }
        composable("tasks"){
            TasksScreen(state = state, onEvent = onEvent, navController = navController)
        }
        composable("schedule"){
            ScheduleScreen(state, onEvent,navController)
        }
        composable("contact"){
            ContactScreen()
        }
        composable("task" + "/{id}",
            arguments = listOf(
                navArgument("id")
                {
                    type = NavType.IntType
                    defaultValue = 1
                }
            )
            ){
            entry ->
            TaskScreen(id = entry.arguments!!.getInt("id"), state)
        }
        composable("create"){
       CreateEditScreen(state, onEvent, navController)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    Project2MadAppTheme()  {
     // TasksScreen()
    }
}