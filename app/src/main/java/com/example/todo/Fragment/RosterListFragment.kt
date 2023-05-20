package com.example.todo.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo.R
import com.example.todo.RosterMotor
import org.koin.androidx.viewmodel.ext.android.viewModel

class RosterListFragment: Fragment() {
    private val motor: RosterMotor by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_roster,container,false);
    }
}