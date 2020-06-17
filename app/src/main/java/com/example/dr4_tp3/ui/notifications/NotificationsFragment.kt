package com.example.dr4_tp3.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.dr4_tp3.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            notificationsViewModel = ViewModelProviders.of(it).get(NotificationsViewModel::class.java)
        }
        btnCadastrarLista.setOnClickListener {
            val confirmacao = notificationsViewModel.verificarNulo(
                view,
                requireContext().applicationContext
            )
            if(!confirmacao){
                Toast.makeText(
                    context, "Por favor preencha todos os campos",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                notificationsViewModel.salvarNoFirestore(requireContext())
                notificationsViewModel.fireAddListToUser(view)
                findNavController().navigate(R.id.navigation_home)
            }
        }
    }
}

