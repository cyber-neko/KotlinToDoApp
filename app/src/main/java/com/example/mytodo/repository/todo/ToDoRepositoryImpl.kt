package com.example.mytodo.repository.todo

import com.example.mytodo.model.todo.ToDo
import com.example.mytodo.model.todo.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//hiltはToDoDaoを知らないのでまずobjectファイル(ToDoModule)を作成する
class ToDoRepositoryImpl @Inject constructor (
    private val dao: ToDoDAO
): ToDoRepository {
    //データベースに保存する処理
    override suspend fun create(title: String, detail: String) {
        val now = System.currentTimeMillis()
        val todo = ToDo(title = title, detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO) {
            dao.create(todo)
        }
    }
}