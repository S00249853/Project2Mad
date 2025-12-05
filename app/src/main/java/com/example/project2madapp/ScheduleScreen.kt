package com.example.project2madapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.DayOfWeek
import java.time.LocalDate


@Composable
fun ScheduleScreen(state: TaskState, onEvent: (TaskEvent) -> Unit,navController: NavController) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
            NameSection("Schedule")
            ScheduleList(state, onEvent, navController)
        }
    }
}

@Composable
fun ScheduleList(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit,
    navController: NavController
) {

    Text("Mondays Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.MONDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it], onEvent, navController)
            }

        }

    }
    Text("Tuesdays Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.TUESDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it], onEvent, navController)
            }

        }
    }
    Text("Wednesday Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.WEDNESDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it], onEvent, navController)
            }

        }
    }
    Text("Thursday Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.THURSDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it], onEvent, navController)
            }

        }
    }
    Text("Friday Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.FRIDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it],onEvent, navController)
            }

        }
    }
    Text("Saturday Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.SATURDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it],onEvent, navController)
            }

        }
    }
    Text("Sunday Tasks",
        fontSize = 40.sp,
        modifier = Modifier.padding(15.dp))
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {
        val today = DayOfWeek.SUNDAY
        items(state.tasks.size) {
            if (state.tasks[it].day == today)
            {
                TaskItem(state.tasks[it],onEvent, navController)
            }

        }
    }
}