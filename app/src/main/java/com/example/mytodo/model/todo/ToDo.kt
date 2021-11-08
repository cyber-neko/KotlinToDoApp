package com.example.mytodo.model.todo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//@Entityでroomが対応するテーブルを作成(テーブル1行分(フィールド)のデータクラスを作成)
@Entity
@Parcelize
data class ToDo(
    //各プロパティはテーブルのフィールド(列)
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val title: String,
    val detail: String,
    val created: Long,
    val modified: Long
) : Parcelable //オブジェクト内部のデータを一旦Parcelという箱に避難させ後から中身を取り出してオブジェクトを復元する
