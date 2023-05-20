package com.example.todo

import androidx.lifecycle.ViewModel

class RosterMotor(private val repo:ToDoRepositary): ViewModel() {
    val items = repo.items
}