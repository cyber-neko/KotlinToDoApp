package com.example.mytodo.repository.todo

import com.example.mytodo.model.todo.ToDo
import kotlinx.coroutines.flow.Flow

//リポジトリはデータの永続化をするところ
interface ToDoRepository {

    fun getAll(): Flow<List<ToDo>>
    //非同期で実行したい場合suspendを使用する
    suspend fun create(title: String, detail: String)


}