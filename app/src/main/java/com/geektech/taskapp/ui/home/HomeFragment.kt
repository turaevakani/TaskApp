package com.geektech.taskapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.App
import com.geektech.taskapp.R
import com.geektech.taskapp.model.Task
import com.geektech.taskapp.databinding.FragmentHomeBinding
import com.geektech.taskapp.ui.home.adapter.TaskAdapter
import com.geektech.taskapp.ui.task.TaskFragment
import com.geektech.taskapp.utils.showToast

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        binding.recyclerView.adapter = adapter
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }


    }

    private fun onClick(task: Task) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            App.db.taskDao().delete(task)
            showToast("Successfully removed")
            setData()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.cancel()
        }
        builder.setTitle("Delete task")
        builder.setMessage("Are you sure to delete the task?")
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData() {
        val tasks = App.db.taskDao().getAll()
        adapter.addTasks(tasks)
    }
}