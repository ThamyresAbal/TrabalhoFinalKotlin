package com.example.dr4_tp3.apiService

import com.example.dr4_tp3.model.AnimeList
import retrofit2.Call
import retrofit2.http.GET

interface AnimesService {

    @GET("/api/edge/anime?page[limit]=10&page[offset]=0")
    fun all(): Call<AnimeList>

}
