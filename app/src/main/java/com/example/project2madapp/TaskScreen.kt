package com.example.project2madapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.project2madapp.Task
import com.example.project2madapp.TopUi

@Composable
fun TaskScreen(task: Task) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column() {
            TopUi()
            NameSection(task.name)
        }
    }
}