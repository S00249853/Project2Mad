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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project2madapp.Task
import com.example.project2madapp.TopUi
import java.time.DayOfWeek

@Composable
fun TaskScreen(id: Int,
               state: TaskState) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
            NameSection("Task")
           TaskInfo(id, state)
        }
    }
}


@Composable
fun TaskInfo(
    id: Int,
    state: TaskState
)
{
    LazyColumn(contentPadding = PaddingValues(
        horizontal = 16.dp, vertical = 16.dp
    ))
    {

        items(state.tasks.size) {
            if (state.tasks[it].id == id) {

                    Text("Name:  " + state.tasks[it].name, fontSize = 30.sp ,modifier = Modifier.padding(16.dp))

                Text("Description:  " + state.tasks[it].description, fontSize = 30.sp ,modifier = Modifier.padding(16.dp))

                Text("Day:  " + state.tasks[it].day.toString(), fontSize = 30.sp ,modifier = Modifier.padding(16.dp))

                Text("Category:  " + state.tasks[it].category.toString(), fontSize = 30.sp ,modifier = Modifier.padding(16.dp))

            }
        }
    }
}