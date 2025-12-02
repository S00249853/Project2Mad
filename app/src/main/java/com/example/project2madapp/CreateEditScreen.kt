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
    Row(horizontalArrangement = Arrangement.SpaceBetween,
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

    var checked1 by remember {mutableStateOf(true)}

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

        TextField(
            value = state.day.toString(),
            onValueChange = {
                onEvent(TaskEvent.SetDay(DayOfWeek.valueOf(it)))
            },
            placeholder = {
                Text(text = "Description")
            }
        )
        TextField(
            value = state.category.toString(),
            onValueChange = {
                onEvent(TaskEvent.SetCategory(Categories.valueOf(it)))
            },
            placeholder = {
                Text(text = "Description")
            }
        )
        Button(modifier = Modifier.padding(20.dp), onClick =
            {
                onEvent(TaskEvent.SaveTask)
            }

        )
        {Text("Save") }

           }
       }





