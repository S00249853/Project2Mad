package com.example.project2mad

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import java.time.DayOfWeek

@Dao
interface TaskDao {



    @Upsert
    suspend fun UpsertTask(task: Task)

    @Delete
    suspend fun DeleteTask(task: Task)

    @Query("SELECT * FROM task ORDER BY name ASC")
    fun GetTasksOrderedByTitle(): Flow<List<Task>>

  // @Query("SELECT * FROM task ORDER BY time ASC")
  //  fun GetTasksOrderedByTime(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY complete ASC")
    fun GetTasksOrderedByDone(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE day = :day")
    fun GetTasksForDay(day: DayOfWeek): List<Task>
}