package com.example.project2madapp

import java.sql.Time
import java.time.DayOfWeek

data class TaskState(
    val tasks: List<Task> = emptyList(),
    val name: String = "",
    val description: String = "",
    val category: Categories = Categories.Cooking,
    val day: DayOfWeek = DayOfWeek.valueOf("MONDAY"),
 //   val time: Time = Time.valueOf("00:00:00"),
   // val deleteWhenDone: Boolean = false,
    val complete: Boolean = false,
    val sortType: SortType = SortType.Title
)

