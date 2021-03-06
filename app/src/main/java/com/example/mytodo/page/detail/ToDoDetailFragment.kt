package com.example.mytodo.page.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mytodo.R
import com.example.mytodo.databinding.TodoDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoDetailFragment: Fragment(R.layout.todo_detail_fragment) {
    private val vm: ToDoDetailViewModel by viewModels()

    private var _binding: TodoDetailFragmentBinding? = null
    private val binding: TodoDetailFragmentBinding get() = _binding!!

    // ナビゲーショングラフで指定したパラメータはフラグメント名Argsクラスのオブジェクトとして渡される
    private val args: ToDoDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this._binding = TodoDetailFragmentBinding.bind(view)

        //argsの中にパラメータとしてToDoが入っているのでこの内容をonViewCreatedでビューにセットする
        val todo = args.todo
        binding.titleText.text = todo.title
        binding.detailText.text = todo.detail
    }

    override fun onDestroy() {
        this._binding = null
        super.onDestroy()
    }
}