package com.app.dr4_tp3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.app.dr4_tp3.R
import com.app.dr4_tp3.viewModel.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_cadastro.*


class CadastroFragment : Fragment() {
    private lateinit var usuarioViewModel: UsuarioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }
        btnCadastrar.setOnClickListener {

             val cadastrou = usuarioViewModel.verificarNulo(view, requireContext().applicationContext)
            if(!cadastrou){
                Toast.makeText(context, "Preencha todas as informações", Toast.LENGTH_SHORT).show()
            }else{
                usuarioViewModel.salvarNoFirestore(requireContext().applicationContext)
                findNavController().navigate(R.id.loginFragment)
            }
        }
        btnVoltar.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }


}
