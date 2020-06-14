package com.example.dr4_tp3.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dr4_tp3.R
import com.example.dr4_tp3.model.ListaFavorito
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.*

class ListaFavoritosAdpter (private val ListaFavoritos : List<ListaFavorito>, val callback:(ListaFavorito, Context)-> Unit) : RecyclerView.Adapter
<ListaFavoritosAdpter.ListaFavoritoViewHolder>() {

    class ListaFavoritoViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtNomeListaFavorito = itemView.txtNomeListaFavorito
        val btnExcluir = itemView.btncExcluir
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
        ListaFavoritoViewHolder.btnExcluir.setOnClickListener {
            val lista = ListaFavoritos[ListaFavoritoViewHolder.adapterPosition]
            callback(lista, parent.context)
        }

        ListaFavoritoViewHolder.btnEditar.setOnClickListener {
            val lista = ListaFavoritos[ListaFavoritoViewHolder.adapterPosition]
            callback(lista, parent.context)
        }

        return ListaFavoritoViewHolder
    }

    override fun getItemCount(): Int = ListaFavoritos.size

    override fun onBindViewHolder(holder: ListaFavoritoViewHolder, position: Int) {
        val ListaFavorito = ListaFavoritos[position]
        holder.txtNomeListaFavorito.text = ListaFavorito.listaFavorito

    }


}