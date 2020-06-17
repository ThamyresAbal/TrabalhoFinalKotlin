package com.example.dr4_tp3.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dr4_tp3.R
import com.example.dr4_tp3.model.ListaFavorito
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.*

class ListaFavoritosAdpter(private val listaFavoritos: MutableList<ListaFavorito>) : RecyclerView.Adapter
<ListaFavoritosAdpter.ListaFavoritoViewHolder>() {

    class ListaFavoritoViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtNomeListaFavorito = itemView.txtNomeListaFavorito
        val btnEditar = itemView.btnEditar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaFavoritoViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layoutlistafavoritos,
                parent,
                false
            )

        val ListaFavoritoViewHolder = ListaFavoritoViewHolder(view)
        return ListaFavoritoViewHolder
    }
    override fun getItemCount(): Int = listaFavoritos.size

    override fun onBindViewHolder(holder: ListaFavoritoViewHolder, position: Int) {
        val listaFavorito = listaFavoritos[position]
        holder.txtNomeListaFavorito.text = listaFavorito.nome

    }
}