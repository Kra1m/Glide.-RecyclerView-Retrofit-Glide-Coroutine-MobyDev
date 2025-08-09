package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.data.Meme
import com.example.retrofit.databinding.ExampleAdapterBinding
import com.example.retrofit.dog.DogsResponse

class ExampleRecyclerAdapter(): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    private val adapterList = mutableListOf<Meme>()
    inner class ExampleViewHolder(private var binding: ExampleAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(memeItem:Meme){
            binding.tvProductTitle.text = memeItem.name
            binding.tvProductPrice.text = memeItem.url
            Glide
                .with(binding.imageView.context)
                .load(memeItem.url)
                .into(binding.imageView);
        }

    //
    //        fun onBind(item:DogsResponse){
//            binding.tvProductTitle.text = item.status
//            binding.tvProductTitle.text = item.status
//            Glide
//                .with(binding.imageView.context)
//                .load(item.message)
//                .into(binding.imageView)
//        }
    }


    fun submitList(list: List<Meme>){
        adapterList.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExampleRecyclerAdapter.ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

}