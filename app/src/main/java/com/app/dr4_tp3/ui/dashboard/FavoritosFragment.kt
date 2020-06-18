package com.app.dr4_tp3.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.app.dr4_tp3.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.dialog_lista_anime.*
import kotlinx.android.synthetic.main.dialog_lista_anime.buttonAdd
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layoutlistafavoritos.*

class FavoritosFragment : Fragment() {

    private lateinit var favoritosViewModel: FavoritosViewModel
    val firebaseStore = FirebaseFirestore.getInstance()
    val fireBaseAuthUser = FirebaseAuth.getInstance().currentUser

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritosViewModel =
            ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritosViewModel.setupRecycleView(rcyListaFavoritos, requireContext())
        //recycleView.adapter!!.notifyItemRemoved(viewHolder.adapterPosition)

        val itemToachHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                favoritosViewModel.listaFavoritos.removeAt(position)
                rcyListaFavoritos.adapter!!.notifyItemRemoved(position)
                firebaseStore.collection("usuarios").document(fireBaseAuthUser?.email!!)
                    .collection("listaFavorito").document()
                    .delete()
            }
        })
        itemToachHelper.attachToRecyclerView(rcyListaFavoritos)

    }
}
