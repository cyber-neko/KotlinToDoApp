package com.example.mytodo.model.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entityでroomが対応するテーブルを作成(テーブル1行分(フィールド)のデータクラスを作成)
@Entity
data class ToDo(
    //各プロパティはテーブルのフィールド(列)
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val title: String,
    val detail: String,
    val created: Long,
    val modified: Long
)
