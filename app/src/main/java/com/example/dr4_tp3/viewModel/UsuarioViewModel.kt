package com.example.dr4_tp3.viewModel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.dr4_tp3.HomeActivity
import com.example.dr4_tp3.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_cadastro.view.*


class UsuarioViewModel : ViewModel(){
    var usuario: Usuario? = null
    val firebaseAuth = FirebaseAuth.getInstance()
    val firebaseStore = FirebaseFirestore.getInstance()


    fun verificarNulo(
        view: View, context: Context
    ): Boolean {
        //Verifico se algum campo está nulo ou vazio
        if (
            view.txtSenha.text.isNullOrBlank() ||
            view.txtEmail.text.isNullOrBlank()
        ) {
            return false
        } else {
            //Caso tudo ocorra ok, começo a alimentar o view model com o resto das informações
             usuario = Usuario(
                email = view.txtEmail.text.toString(),
                senha = view.txtSenha.text.toString()



            )
            return true
        }

    }


    fun salvarNoFirestore(context: Context){

        var collection = firebaseStore.collection("usuarios")

        var user: MutableMap<String, Any> = HashMap()
        user["email"] = usuario!!.email
        user["senha"] = usuario!!.senha

        collection.document(usuario!!.email).set(user)
        criarAth(usuario!!.email, usuario!!.senha, context)

    }

    fun criarAth(email:String, senha: String, context: Context){
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener {
                if(it != null){
                    Toast.makeText(context, "Cadastro realizado com sucesso",
                        Toast.LENGTH_SHORT).show()
                }else{
                    Log.d("autentificacao", "cadastrado")
                }
            }
            .addOnFailureListener {
                if(it.message == "The email address is already in use by another account"){
                    Toast.makeText(context, "Email já cadastrado!", Toast.LENGTH_SHORT).show()
                }else{
                    Log.d("Erro", "Erro no cadastro")
                }
            }
    }

    fun loginFirestore(context: Context, boxEmail: String, boxSenha: String){

        firebaseAuth.signInWithEmailAndPassword(boxEmail, boxSenha)
            .addOnSuccessListener {
                Toast.makeText(context, "Bem vindo ${it.user!!.email}", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))


            }
            .addOnFailureListener {
                if(it.message == "The email address is baldy formatted"){
                    Toast.makeText(context, "Por favor insira um email com formato válido", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(context, "Email ou senha inválidos!", Toast.LENGTH_SHORT).show()

                }
            }
    }



}