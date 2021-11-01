package com.example.mytodo.model.todo

import androidx.room.*

import kotlinx.coroutines.flow.Flow


//roomではinterfaceでdaoを作成
@Dao
interface ToDoDAO {

    @Query("select * from ToDo where created < :startCreated order by created")
    fun getWithCreated(startCreated: Long, limit: Int): Flow<List<ToDo>>
    //KotlinコルーチンのFlow<T>にすることでデータベースに変更があると新しい結果が流れてくる
    @Insert
    suspend fun create(todo: ToDo)

    @Update
    suspend fun update(todo: ToDo)

    @Delete
    suspend fun delete(todo: ToDo)
}