package com.example.project2mad

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Clock
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.TimeZone

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
TopUi()
        }
    }
}

@Composable
fun TopUi(
    name: String = "Daniel"


) {
    Row(
horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .height(62.dp)
    ) {
      //  Icon(painter = painterResource(id = android.R.drawable.btn_dialog), contentDescription = "")
        Text(name, fontSize = 18.sp)
    }
}

@Composable
fun TaskList(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit,
    onGetEvent: (TaskEvent) -> List<Task>
) {
    val today = LocalDate.now().dayOfWeek
    Text("Todays Tasks",
        fontSize = 64.sp)
    LazyColumn()
    {

val tasks = onGetEvent(TaskEvent.GetDay(today))
items(tasks.size) {
    TaskItem(tasks[it])
}

    }
    Text("Tommorows Tasks",
        fontSize = 64.sp)
    LazyColumn()
    {

        val tasks = onGetEvent(TaskEvent.GetDay(today + 1))
        items(tasks.size) {
            TaskItem(tasks[it])
        }
    }
}



@Composable
fun TaskItem(
    task: Task
)
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .height(62.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(15.dp)

    )
    {
         Text(task.name)
       // Text(task.time.toString())

        Icon(if(task.complete) {
            painterResource(id = com.example.project2madapp.R.drawable.baseline_check_24)

        }
            else{
            painterResource(id = com.example.project2madapp.R.drawable.baseline_close_24)
        },
            contentDescription = ""

        )

        Icon(painterResource(id = com.example.project2madapp.R.drawable.outline_edit_24), contentDescription = "")
    }
}