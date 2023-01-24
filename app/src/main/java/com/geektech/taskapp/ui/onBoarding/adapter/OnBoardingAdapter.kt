package com.geektech.taskapp.ui.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.taskapp.databinding.ItemOnboardingBinding
import com.geektech.taskapp.model.OnBoard
import com.geektech.taskapp.utils.loadImage

class OnBoardingAdapter(private val onClick:()->Unit):Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf(
        OnBoard("Track your tasks progress","Never forget important things","https://kissflow.com/hubfs/Kissflow%20Workflow%20Images/employee-onboarding.png"),
        OnBoard("Your personal task manager","Free up some time for your self","https://media.istockphoto.com/id/1142608291/vector/businessman-character-mark-checklist-with-pen-businesswoman-completion-business-task-goal.jpg?s=2048x2048&w=is&k=20&c=niEriAjJEwEGFZsWClQlLeEMGy_b-P6Xe-0iB0-unns="),
        OnBoard("Complete task easily","Leave no job behind","https://media.istockphoto.com/id/1350248776/vector/achieving-goals-concept.jpg?s=2048x2048&w=is&k=20&c=-cPzXYMWeAymgaKSPSEQt-bj-GCKsdedpvj0VubAiJM=")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding):ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text=onBoard.title
            binding.tvDesc.text=onBoard.desc
            binding.imgOnBoarding.loadImage(onBoard.image.toString())
            binding.btnStart.isVisible = adapterPosition==data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }

    }
}