package com.example.mytodo

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.TodoItemBinding
import com.example.mytodo.model.todo.ToDo

class ToDoAdapter: ListAdapter<ToDo, ToDoAdapter.ViewHolder>(callbacks) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bindTo(todo)
    }

    //リスト1行分のビューを保持
    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(todo: ToDo) {
            binding.titleText.text = todo.title
            binding.createdText.text = DateFormat.format(
                "yyyy-MM-dd hh:mm:ss",
                todo.created
            )
        }
    }

    companion object {
        private val callbacks = object: DiffUtil.ItemCallback<ToDo>() {
            override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.created == newItem.created
            }

        }
    }
}