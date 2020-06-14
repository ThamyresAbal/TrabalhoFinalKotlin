package com.example.dr4_tp3.ui.dashboard

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.dr4_tp3.model.ListaFavorito
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class DashboardViewModel : ViewModel() {
    var listaFavoritos: ListaFavorito? = null
    val firebaseStore = FirebaseFirestore.getInstance()
    fun getListaUsuario(){
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var listaFavoritosRef =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")


    }

    fun fireAddListToUser(view: View) {
        val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

        var listaFavoritosRef =
            firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                .collection("listaFavorito")

        listaFavoritosRef
            .document(view.txtNomeLista.text.toString())
            .set({})

    }

}