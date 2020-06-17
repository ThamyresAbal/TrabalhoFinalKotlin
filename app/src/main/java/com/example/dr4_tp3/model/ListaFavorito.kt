package com.example.dr4_tp3.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference

class ListaFavorito(

    @DocumentId
    var nome :String? = null,
    var listaFavorito: String? = null
   /* var listaFavorito2: List<DocumentReference>? = null*/

) {
}