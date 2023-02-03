package com.geektech.taskapp.ui.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.taskapp.R
import com.geektech.taskapp.databinding.ItemOnboardingBinding
import com.geektech.taskapp.model.OnBoard
import com.geektech.taskapp.utils.loadImage

class OnBoardingAdapter(private val onClick:()->Unit):Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf(
        OnBoard("Track your tasks progress","Never forget important things", R.raw.task_anim),
        OnBoard("Your personal task manager","Free up some time for your self",R.raw.task_anim1),
        OnBoard("Complete task easily","Leave no job behind",R.raw.task_anim2)
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
            onBoard.image?.let{binding.animationView.setAnimation(it)}
            binding.btnStart.isVisible = adapterPosition==data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }

    }
}