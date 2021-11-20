package com.jasbir.avengersassemble.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jasbir.avengersassemble.R
import com.jasbir.repository.remote.response.MarvelCharacters
import timber.log.Timber


class CharacterAdapter : PagingDataAdapter<MarvelCharacters.Data.CharacterResult, CharacterAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        val imagePath = "${getItem(position)?.thumbnail?.path.toString()}.${getItem(position)?.thumbnail?.extension}"
        Timber.e("Image Path: $imagePath")
        Glide.with(holder.imageView.context)
            .load(imagePath)
            .into(holder.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.character_image)
        fun bind(data: MarvelCharacters.Data.CharacterResult) {



        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<MarvelCharacters.Data.CharacterResult>() {
        override fun areItemsTheSame(oldItem: MarvelCharacters.Data.CharacterResult, newItem: MarvelCharacters.Data.CharacterResult): Boolean {
            return oldItem.thumbnail == newItem.thumbnail
        }

        override fun areContentsTheSame(oldItem: MarvelCharacters.Data.CharacterResult, newItem: MarvelCharacters.Data.CharacterResult): Boolean {
            return oldItem.thumbnail == newItem.thumbnail
                    && oldItem.thumbnail == newItem.thumbnail
        }

    }

}