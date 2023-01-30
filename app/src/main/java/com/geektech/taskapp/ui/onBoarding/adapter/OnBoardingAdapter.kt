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
        OnBoard("Track your tasks progress","Never forget important things","https://assets5.lottiefiles.com/packages/lf20_hilg7ehf.json"),
        OnBoard("Your personal task manager","Free up some time for your self","https://assets4.lottiefiles.com/packages/lf20_138qcknv.json"),
        OnBoard("Complete task easily","Leave no job behind","https://assets4.lottiefiles.com/packages/lf20_fxvz0c.json")
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
            binding.animationView.setAnimationFromUrl(onBoard.image.toString())
            binding.btnStart.isVisible = adapterPosition==data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }

    }
}