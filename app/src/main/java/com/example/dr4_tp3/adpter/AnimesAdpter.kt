package com.example.dr4_tp3.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dr4_tp3.R
import kotlinx.android.synthetic.main.layouthome.view.*

class AnimesAdpter(private val animes: MutableList<String>): RecyclerView.Adapter
<AnimesAdpter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtNomeAnime = itemView.txtNomeAnime
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layouthome,
                parent,
                false
            )
        val AnimeViewHolder = AnimeViewHolder(view)
        return AnimeViewHolder
    }

    override fun getItemCount(): Int = animes.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animes[position]
        // filme.capa : Bitmap | Int (Resource)
        // ImageView.setImageBitmap(filme.capa)
        // ImageView.setImageResource(filme.capa)
        holder.txtNomeAnime.text = anime.toString()

    }
}