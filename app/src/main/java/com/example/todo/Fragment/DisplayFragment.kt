package com.example.todo.Fragment

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.todo.SingleModelMotor
import com.example.todo.databinding.TodoDisplayBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DisplayFragment: Fragment() {
    private val args: DisplayFragmentArgs by navArgs()
    private var binding: TodoDisplayBinding? = null

    private val motor: SingleModelMotor by viewModel(){ parametersOf(args.modelId) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = TodoDisplayBinding.inflate(layoutInflater,container,false)
                .apply { binding = this }
                .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        motor.getModel()?.let {
            binding?.apply {
                completed.visibility = if(it.isCompleted) View.VISIBLE else View.INVISIBLE
                notesText.text = it.notes
                descText.text = it.description
                dateText.text = DateUtils.getRelativeDateTimeString(
                        requireContext(),
                it.createdOn.toEpochMilli(),
                DateUtils.MINUTE_IN_MILLIS,
                DateUtils.WEEK_IN_MILLIS,
                0
                )
            }
        }
    }
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}