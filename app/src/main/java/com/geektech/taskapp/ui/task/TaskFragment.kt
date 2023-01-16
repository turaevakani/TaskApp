package com.geektech.taskapp.ui.task

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.Task
import com.geektech.taskapp.databinding.FragmentDashboardBinding
import com.geektech.taskapp.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    companion object{
        const val RESULT_TASK = "result_task"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            setFragmentResult(RESULT_TASK, bundleOf("task" to Task(binding.edTitle.text.toString(),
                binding.edDesc.text.toString())))
            findNavController().navigateUp()

        }

    }

}