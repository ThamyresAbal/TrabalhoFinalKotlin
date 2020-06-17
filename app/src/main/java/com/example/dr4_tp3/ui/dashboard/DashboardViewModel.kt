package com.example.dr4_tp3.ui.dashboard

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dr4_tp3.adpter.ListaFavoritosAdpter
import com.example.dr4_tp3.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.layoutlistafavoritos.view.*


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

                 listaFavoritos = it.toObjects(ListaFavorito::class.java)
                recycleView.adapter = ListaFavoritosAdpter(listaFavoritos, this::callbackListaFavoritos)
                recycleView.layoutManager = LinearLayoutManager(context)

        }.addOnFailureListener{
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }
    }

     fun callbackListaFavoritos(listaFavorito: ListaFavorito, view: View, context: Context ) {
         val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser



         view.btncExcluir.setOnClickListener{

            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito").document(view.txtNomeListaFavorito.text.toString())
                .delete()

                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }


        }


    }


}