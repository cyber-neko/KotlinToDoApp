package com.example.mytodo.page.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodo.repository.todo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(
    /*通常はviewmodelに引数のあるコンストラクタを追加するとクラッシュする
     *そこでviewomdel用hiltライブラリを使用する
     */
    private val repo: ToDoRepository
): ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val done = MutableLiveData<Boolean>()

    fun save(title: String, detail: String) {
        //タイトルが空でったらエラーメッセージを出す
        if (title.trim().isEmpty()) {
            errorMessage.value = "Please input title"
            return
        }
        //リポジトリ経由で実際の保存処理を行う
        viewModelScope.launch {
            try {
                /*保存処理は非同期で行われるのでviewModelScopeで実行
                 *保存処理中に画面回転が発生しても処理は継続されバックボタンなどで
                 *viewmodelが破棄されるタイミングでキャンセルされる
                 */
                repo.create(title, detail)
                done.value = true
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}