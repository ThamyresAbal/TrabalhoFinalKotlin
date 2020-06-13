package com.example.dr4_tp3.apiService

import com.example.dr4_tp3.model.Anime
import retrofit2.http.GET

interface AnimesService {

    // Listar todos os Recursos
    @GET("/anime?filter[text]=Naruto")
    fun all() : retrofit2.Call<List<Anime>>

}
