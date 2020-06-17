package com.example.dr4_tp3.ui.dashboard

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dr4_tp3.adpter.ListaFavoritosAdpter
import com.example.dr4_tp3.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class DashboardViewModel : ViewModel() {
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

            recycleView.adapter = ListaFavoritosAdpter(anime)
            recycleView.layoutManager = LinearLayoutManager(context)
            Log.i("brabo","errou")

        }.addOnFailureListener{
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            Log.i("koemane","errou")
        }
    }
 }