package com.example.project2madapp

import java.sql.Time
import java.time.DayOfWeek

enum class SortType{
    Title,
    Done
}

sealed interface TaskEvent {
    object SaveTask: TaskEvent
    data class SetName(val name: String): TaskEvent
    data class SetDescription(val description: String): TaskEvent
    data class SetCategory(val category: Categories): TaskEvent
    data class SetDay(val day: DayOfWeek): TaskEvent
   // data class SetTime(val time: Time): TaskEvent
    //data class SetDelete(val delete: Boolean): TaskEvent
    data class SetComplete(val complete: Boolean): TaskEvent
    data class  SortTasks(val sortType: SortType): TaskEvent

    data class GetDay(val day: DayOfWeek): TaskEvent
    data class DeleteTask(val task: Task): TaskEvent
}