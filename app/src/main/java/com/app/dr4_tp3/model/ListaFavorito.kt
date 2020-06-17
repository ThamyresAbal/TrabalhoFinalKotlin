package com.app.dr4_tp3.model

import com.google.firebase.firestore.DocumentId

class ListaFavorito(

    @DocumentId
    var nome :String? = null,
    var listaFavorito: String? = null
   /* var listaFavorito2: List<DocumentReference>? = null*/

) {
}