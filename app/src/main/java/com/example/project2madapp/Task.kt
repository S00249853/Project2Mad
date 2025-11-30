package com.example.project2mad

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.time.DayOfWeek

enum class Categories{
    Outdoors,
    College,
    Cleaning,
    Cooking
}


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val category: Categories,
    val day: DayOfWeek,
  //  val time: Time,
    val deleteWhenDone: Boolean,
    val complete: Boolean

)
