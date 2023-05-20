package com.example.todo

import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.TodoRowBinding

class RosterRowHolder(private val binding: TodoRowBinding,
                      private val onCheckBoxToggle: (ToDoModel) -> Unit,
                      private val onRowClick: (ToDoModel) -> Unit
                      ): RecyclerView.ViewHolder(binding.root)
{

    fun bind(model: ToDoModel){
        binding.apply {
            root.setOnClickListener{ onRowClick(model)}
            isCompleted.isChecked = model.isCompleted
            isCompleted.setOnCheckedChangeListener {_,_ -> onCheckBoxToggle(model)}
            desc.text = model.description
        }
    }
}