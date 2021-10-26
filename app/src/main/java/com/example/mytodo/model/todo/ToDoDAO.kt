package com.example.mytodo.model.todo

import androidx.room.*
import java.util.concurrent.Flow


//roomではinterfaceでdaoを作成
@Dao
interface ToDoDAO {

    @Query("select * from ToDo where created < :startCreated order by created")
    fun getWithCreated(startCreated: Long, limit: Int): Flow<List<ToDo>>

    @Insert
    suspend fun create(todo: ToDo)

    @Update
    suspend fun update(todo: ToDo)

    @Delete
    suspend fun delete(todo: ToDo)
}