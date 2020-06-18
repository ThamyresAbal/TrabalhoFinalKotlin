package com.app.dr4_tp3.fragment

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import com.app.dr4_tp3.R
import com.app.dr4_tp3.model.Anime
import com.app.dr4_tp3.model.ListaFavorito
import com.app.dr4_tp3.ui.dashboard.FavoritosViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_lista_animes.*


@Suppress("UNREACHABLE_CODE")
class ListaAnimesFragment : Fragment() {
    private lateinit var favoritosViewModel: FavoritosViewModel
    val firebaseStore = FirebaseFirestore.getInstance()
    val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_animes, container, false)
        favoritosViewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
/*
        val item = Intent().getExtras()?.getString("itemView")

        var listAnimesRef= firebaseStore
            .collection("usuarios")
            .document(fireBaseAuthUser?.email!!)
            .collection("listaFavorito").document({item}.toString())
        listAnimesRef.get().addOnSuccessListener {
            var anime = it.toObjects(Anime::class.java)

             listRetornoFirebase.adapter = ArrayAdapter<Anime>(
                requireContext().applicationContext,
                android.R.layout.simple_list_item_1
                anime
            )
        }*/
    }

}