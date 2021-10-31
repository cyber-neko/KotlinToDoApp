package com.example.mytodo.repository.todo

//リポジトリはデータの永続化をするところ
interface ToDoRepository {
    //非同期で実行したい場合suspendを使用する
    suspend fun create(title: String, detail: String)
}