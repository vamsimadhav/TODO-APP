package com.example.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.todo.databinding.TodoRowBinding

class RosterAdapter(
    private val inflater: LayoutInflater,
    private val checkBoxToggle: (ToDoModel) -> Unit,
    private val onRowClick: (ToDoModel) -> Unit
                    ): ListAdapter<ToDoModel,RosterRowHolder>(DiffCallBack)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RosterRowHolder(
            TodoRowBinding.inflate(inflater,parent,false),
            checkBoxToggle,
            onRowClick
        )

    override fun onBindViewHolder(holder: RosterRowHolder, position: Int) {
       holder.bind(getItem(position))
    }

    private object DiffCallBack: DiffUtil.ItemCallback<ToDoModel>(){
        override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel) =
            oldItem.isCompleted == newItem.isCompleted &&
                    oldItem.description == newItem.description

    }
}