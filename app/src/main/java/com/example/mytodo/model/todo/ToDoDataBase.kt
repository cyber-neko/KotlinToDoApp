package com.example.mytodo.model.todo

import androidx.room.Database
import androidx.room.RoomDatabase

//ファイルにどのテーブル(エンティティ)を含めるかをentitiesで指定
@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDataBase:  RoomDatabase() {
    //daoを返すメソッドを実装する必要がある
    abstract  fun todoDAO(): ToDoDAO
}