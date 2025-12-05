package com.example.project2madapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBoxScope
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Index
import com.example.project2madapp.TopUi
import org.intellij.lang.annotations.JdkConstants

@Composable
fun TasksScreen(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
            OrderSection(state, onEvent)
            TasksList(state, onEvent, navController)
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {  Button(onClick =
                {navController.navigate("create")
                }
            ) {
                Text("Add Task")
            }}

        }



        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderSection(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit
)
{
    var isExpanded by remember{
        mutableStateOf(false)
    }

    var SelectedValue by remember {
        mutableStateOf("Order")
    }

    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(15.dp)
    ) {
        Text("Tasks", fontSize = 64.sp)
        Button(onClick = { isExpanded = !isExpanded },
            modifier = Modifier.padding(start = 80.dp)
        )
        {
            Text(SelectedValue)
        }
       DropdownMenu(expanded = isExpanded, onDismissRequest = {isExpanded = false})
        {
            SortType.entries.forEach { sortType ->
                DropdownMenuItem(text = {Text(sortType.toString())},
                    onClick = { onEvent(TaskEvent.SortTasks(sortType))
                    SelectedValue = sortType.toString()
                    })
            }
        }
    }
}

@Composable
fun TasksList(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit,
    navController: NavController
)
{
    LazyColumn(modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.tasks.size){
            TaskItem(state.tasks[it],onEvent, navController)
        }
    }

}