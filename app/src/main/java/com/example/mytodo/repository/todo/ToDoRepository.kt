package com.example.mytodo.repository.todo

//リポジトリはデータの永続化をするところ
interface ToDoRepository {
    suspend fun create(title: String, detail: String)
}