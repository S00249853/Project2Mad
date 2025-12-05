package com.example.project2madapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.util.TableInfo
import java.time.DayOfWeek


@Composable
fun CreateEditScreen(state: TaskState,
                     onEvent: (TaskEvent) -> Unit,
                     navController: NavController) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
NameSection("Add Tasks")
            AddTask(state, onEvent, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameSection(
name: String
)
{
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(15.dp)
    ) {
        Text(name, fontSize = 64.sp)
    }
}

@Composable
fun AddTask(state: TaskState,
            onEvent: (TaskEvent) -> Unit,
            navController: NavController){

    var isExpanded by remember{
        mutableStateOf(false)
    }

    var isExpanded2 by remember{
        mutableStateOf(false)
    }

    var SelectedText by remember {
        mutableStateOf("Day")
    }


    var SelectedText2 by remember {
        mutableStateOf("Category")
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        TextField(
            value = state.name,
            onValueChange = {
                onEvent(TaskEvent.SetName(it))
            },
            placeholder = {
                Text(text = "Name")
            }
        )

        TextField(
            value = state.description,
            onValueChange = {
                onEvent(TaskEvent.SetDescription(it))
            },
            placeholder = {
                Text(text = "Description")
            }
        )


       Button(onClick = { isExpanded = !isExpanded }
       )
        {
            Text(SelectedText)
       }
        DropdownMenu(expanded = isExpanded, onDismissRequest = {isExpanded = false})
        {
            DayOfWeek.entries.forEach { day ->
                DropdownMenuItem(text = {Text(day.toString())},
                    onClick = {
                        onEvent(TaskEvent.SetDay(day))
                        SelectedText = day.toString()
                    })
            }
        }
        Button(onClick = { isExpanded2 = !isExpanded2 }
        )
        {
            Text(SelectedText2)
        }
        DropdownMenu(expanded = isExpanded2, onDismissRequest = {isExpanded2 = false})
        {
            Categories.entries.forEach { category ->
                DropdownMenuItem(text = {Text(category.toString())},
                    onClick = { onEvent(TaskEvent.SetCategory(category))
                    SelectedText2 = category.toString()})
            }
        }
        Button(modifier = Modifier.padding(20.dp), onClick =
            {
                onEvent(TaskEvent.SaveTask)
                navController.navigate("tasks")
            }

        )
        {Text("Save") }

           }
       }





