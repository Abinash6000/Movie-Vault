package com.project.movievault.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.movievault.databinding.MovieItemBinding
import com.project.movievault.model.ShowDetails
import com.project.movievault.model.ShowResponse

class ShowsAdapter(private val myDataset: List<ShowResponse>, private val listener: MyShowsItemClickListener) : RecyclerView.Adapter<ShowsAdapter.ShowsViewHolder>() {
    class ShowsViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(showResponse: ShowResponse, listener: MyShowsItemClickListener) {
            binding.titleTV.text = showResponse.show.name
            binding.image = showResponse.show.image
            binding.root.setOnClickListener {
                listener.onShowItemClicked(showResponse.show)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        return ShowsViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = myDataset.size

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
//        val data = myDataset[position]
//        val urlToImage = data.urlToImage
//        if(urlToImage!=null)
        holder.bind(myDataset[position], listener)
//        else Log.d("adfasl", "Url of image was null here")
    }
}

interface MyShowsItemClickListener {
    fun onShowItemClicked(showDetails: ShowDetails)
}