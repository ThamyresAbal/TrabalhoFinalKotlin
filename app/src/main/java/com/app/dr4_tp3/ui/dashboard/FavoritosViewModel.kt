package com.app.dr4_tp3.ui.dashboard

import android.R.attr.fragment
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.dr4_tp3.HomeActivity
import com.app.dr4_tp3.R
import com.app.dr4_tp3.adpter.ListaFavoritosAdpter
import com.app.dr4_tp3.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.dialog_lista_anime.view.*
import kotlinx.android.synthetic.main.dialog_lista_anime.view.buttonVoltar
import kotlinx.android.synthetic.main.dialog_lista_editar.view.*


class FavoritosViewModel : ViewModel() {
    //var listaFavoritos: ListaFavorito? = null
    val firebaseStore = FirebaseFirestore.getInstance()


    lateinit var  listaFavoritos: MutableList<ListaFavorito>
    fun setupRecycleView(
        recycleView: RecyclerView, context: Context
    ){


        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var collection =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")
        val task = collection.get()
        task.addOnSuccessListener {
            val anime = it.toObjects(ListaFavorito::class.java)

            recycleView.adapter = ListaFavoritosAdpter(anime,this::addAnimes,this::editarLista/*, this::exibirListaAnimes*/)
            recycleView.layoutManager = LinearLayoutManager(context)
            Log.i("brabo","errou")

        }.addOnFailureListener{
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            Log.i("brabo","errou")
        }
    }
    /*fun exibirListaAnimes(anime: ListaFavorito, context: Context,view:View){

       context.startActivity(Intent(context, HomeActivity::class.java).apply{putExtra("item", anime.toString())})

    }*/

    fun editarLista(anime: ListaFavorito, context: Context,view:View){
        val myDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_lista_editar, null)
        val myBuilder = AlertDialog.Builder(context)
            .setView(myDialogView)
            .setTitle("Editar nome da lista")

        val myAlertDialog = myBuilder.show()
        myDialogView.buttonConfirmar.setOnClickListener {
            if (myDialogView.editTextNovoNome.text.isNullOrBlank()) {
                alterarNomeLista(myDialogView.editTextNovoNome.text.toString(), anime)
            }else{
                Toast.makeText(context, "nulo", Toast.LENGTH_LONG).show()
            }
        }
        myDialogView.buttonVoltar.setOnClickListener {
            myAlertDialog.dismiss()
        }
    }

    fun addAnimes(anime: ListaFavorito, context: Context,view:View) {
        val myDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_lista_anime, null)
        val myBuilder = AlertDialog.Builder(context)
            .setView(myDialogView)
            .setTitle("Adicione um anime")

        val myAlertDialog = myBuilder.show()
        myDialogView.buttonVoltar.setOnClickListener {
            myAlertDialog.dismiss()
        }
        myDialogView.buttonAdd.setOnClickListener {
            if (myDialogView.editTextNovoAnime.text.isNullOrBlank()) {
                salvarAnime(myDialogView.editTextNovoAnime.text.toString(),anime)
            } else {
                Toast.makeText(context, "nulo", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun alterarNomeLista(editTextNovoNome: String,anime: ListaFavorito){
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var listaFavoritosRef =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")
        listaFavoritosRef
            .document({anime}.toString())
            .set({editTextNovoNome})
    }

    fun salvarAnime(novoAnime: String,anime: ListaFavorito){
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var listaFavoritosRef =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")
        val um = firebaseStore.collection("usuarios")
        listaFavoritosRef
            .document(anime.toString())
            .set(novoAnime)

    }
 }