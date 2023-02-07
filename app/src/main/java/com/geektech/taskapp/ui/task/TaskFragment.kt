package com.geektech.taskapp.ui.task

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.geektech.taskapp.App
import com.geektech.taskapp.model.Task
import com.geektech.taskapp.databinding.FragmentTaskBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private val db = Firebase.firestore

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
            onSave()
        }
        getClick()
    }

    private fun onSave() {
        val task = Task(
            title = binding.edTitle.text.toString(),
            description = binding.edDesc.text.toString()
        )
        putTask(task)
        App.db.taskDao().insertAll(task)
        findNavController().navigateUp()
    }

    private fun getClick() {
        val title = arguments?.getString("title")
        val desk = arguments?.getString("desc")
        binding.edTitle.setText(title)
        binding.edDesc.setText(desk)
    }

    private fun putTask(task: Task){
        FirebaseAuth.getInstance().currentUser?.uid?.let {
            db.collection(it).add(task).addOnSuccessListener{
                Log.e("kani","onSave: success!!")
            }.addOnFailureListener{
                Log.e("kani","onSave: " + it.message)
            }
        }
    }

    companion object{
        const val RESULT_TASK = "result_task"
    }

}