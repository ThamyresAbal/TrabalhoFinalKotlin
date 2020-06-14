package com.example.dr4_tp3.ui.dashboard

import android.content.Context
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



    fun setupRecycleView(
        recycleView: RecyclerView, context: Context
    ){

        //progressBar.visibility = View.VISIBLE
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var collection =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")

        val task = collection.get()

        task.addOnSuccessListener {

                val listaFavoritos = it.toObjects(ListaFavorito::class.java)

                recycleView.adapter = ListaFavoritosAdpter(listaFavoritos, this::callbacListaFavoritos)
                recycleView.layoutManager = LinearLayoutManager(context)

        }.addOnFailureListener{
            Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun callbacListaFavoritos(context: Context, view: View) {

        view.btncExcluir.setOnClickListener{



        }


    }


}