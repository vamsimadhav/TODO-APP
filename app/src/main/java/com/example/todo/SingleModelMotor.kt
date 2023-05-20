package com.example.todo

import androidx.lifecycle.ViewModel

class SingleModelMotor(
            private val modelId: String,
            private val repo: ToDoRepositary
            ): ViewModel() {

      fun getModel() = repo.find(modelId);

}