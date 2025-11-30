package com.example.project2mad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModel(private  val dao: TaskDao): ViewModel() {

    private val sortType = MutableStateFlow(SortType.Title)
    private  val tasks = sortType
        .flatMapLatest { sortType ->
            when(sortType){
                SortType.Title -> dao.GetTasksOrderedByTitle()
             //   SortType.Time -> dao.GetTasksOrderedByTime()
                SortType.Done -> dao.GetTasksOrderedByDone()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
private val state = MutableStateFlow(TaskState())
    val State = combine(state, sortType, tasks){state, sortType, tasks ->
        state.copy(
            tasks = tasks,
            sortType = sortType
        )
    } .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TaskState())


    fun onEvent(event: TaskEvent)
    {
         when(event){
             TaskEvent.SaveTask -> {
                   val name = State.value.name
                 val description = State.value.description
                 val category = State.value.category
                 val day = State.value.day
               //  val time = State.value.time
                 val delete = State.value.deleteWhenDone
                 val complete = State.value.complete

                 if (name.isBlank() || description.isBlank())
                 {
                     return
                 }

                 val task = Task(
                     name = name,
                     description = description,
                     category = category,
                     day = day,
                    // time = time,
                     deleteWhenDone = delete,
                     complete = complete
                 )
                 viewModelScope.launch {
                     dao.UpsertTask(task)
                 }

             }
             is TaskEvent.SetCategory -> {
                 state.update { it.copy(
                    category = event.category
                 ) }
             }
             is TaskEvent.SetComplete -> {
                 state.update { it.copy(
                     complete = event.complete
                 ) }
             }
             is TaskEvent.SetDay -> {
                 state.update { it.copy(
                     day = event.day
                 ) }
             }
             is TaskEvent.SetDelete -> {
                 state.update { it.copy(
                     deleteWhenDone = event.delete
                 ) }
             }
             is TaskEvent.SetDescription -> {
                 state.update { it.copy(
                     description = event.description
                 ) }
             }
             is TaskEvent.SetName -> {
                 state.update { it.copy(
                     name = event.name
                 ) }
             }
           //  is TaskEvent.SetTime -> {
           //      state.update { it.copy(
               //      time = event.time
           //      ) }
            // }
             is TaskEvent.SortTasks-> {
                 sortType.value = event.sortType
             }
             is TaskEvent.DeleteTask -> {
                 viewModelScope.launch {
                     dao.DeleteTask(event.task)
                 }
             }

             is TaskEvent.GetDay -> {
                 viewModelScope.launch {
                    dao.GetTasksForDay(event.day)

                 }
             }
         }
    }
}