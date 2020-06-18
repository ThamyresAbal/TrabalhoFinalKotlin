package com.app.dr4_tp3.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.dr4_tp3.R
import com.app.dr4_tp3.model.ListaFavorito
import kotlinx.android.synthetic.main.dialog_lista_anime.view.*
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.*
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.buttonAdd
import kotlin.reflect.KFunction2

class ListaFavoritosAdpter(
    private val listaFavoritos: MutableList<ListaFavorito>,
    val addAnime:(ListaFavorito, Context,view:View)-> Unit,
    val editaNomeLista:(ListaFavorito, Context,view:View)-> Unit
   /* val exibirLista:(ListaFavorito, Context,view:View) -> Unit*/

) : RecyclerView.Adapter
<ListaFavoritosAdpter.ListaFavoritoViewHolder>() {

    class ListaFavoritoViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val txtNomeListaFavorito = itemView.txtNomeListaFavorito
        val editar = itemView.buttonEditar
        val add = itemView.buttonAdd
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaFavoritoViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.layoutlistafavoritos,
                parent,
                false
            )

        val listaFavoritoViewHolder = ListaFavoritoViewHolder(view)
        //exibe os animes na lista
        /*listaFavoritoViewHolder.itemView.setOnClickListener {
            val anime = listaFavoritos[listaFavoritoViewHolder.adapterPosition]
            exibirLista(anime, parent.context,view)
        }*/
        //adiciona um novo anime a lista
        listaFavoritoViewHolder.add.setOnClickListener {
            val anime = listaFavoritos[listaFavoritoViewHolder.adapterPosition]
            addAnime(anime, parent.context,view)
        }
        // edita o nome da lista
        listaFavoritoViewHolder.editar.setOnClickListener {
            val anime = listaFavoritos[listaFavoritoViewHolder.adapterPosition]
            editaNomeLista(anime, parent.context,view)
        }
        return listaFavoritoViewHolder
    }
    override fun getItemCount(): Int = listaFavoritos.size

    override fun onBindViewHolder(holder: ListaFavoritoViewHolder, position: Int) {
        val listaFavorito = listaFavoritos[position]
        holder.txtNomeListaFavorito.text = listaFavorito.nome

    }
}