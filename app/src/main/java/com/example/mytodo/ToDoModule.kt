package com.example.mytodo

import android.content.Context
import androidx.room.Room
import com.example.mytodo.model.todo.ToDoDAO
import com.example.mytodo.model.todo.ToDoDataBase
import com.example.mytodo.repository.todo.ToDoRepository
import com.example.mytodo.repository.todo.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ToDoModule {

    @Singleton
    @Provides
    fun provideToDoDatabase( //hiltはprovideToDoDAOの引数のToDoDataBaseをしらないのでメソッドを作成し伝える
        @ApplicationContext context: Context
    ): ToDoDataBase {
        return Room.databaseBuilder(
            context,
            ToDoDataBase::class.java,
            "todo.db"
        ).build()
    }

    @Singleton //複数箇所から必要とされた場合、同じインスタンスがセットされるようになる
    @Provides
    fun provideToDoDAO(db: ToDoDataBase): ToDoDAO {
        return db.todoDAO()
    }
}

//ToDoRepositoryインスタンスの作り方もhiltに教える
//objectとclassの場合はこの引数
@Module
@InstallIn(ApplicationComponent::class)
abstract class ToDoRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindToDoRepository(
        impl: ToDoRepositoryImpl //メソッドの引数で実際にどのインスタンスを使うかを指定
    ): ToDoRepository //メソッドの戻り値の型でどのインターフェースのインスタンスの作り方かを指定
}