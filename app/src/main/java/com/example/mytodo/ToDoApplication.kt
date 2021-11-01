package com.example.mytodo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//アプリケーションクラスはmanifestファイルに記述する必要がある
@HiltAndroidApp
class ToDoApplication: Application() {
}