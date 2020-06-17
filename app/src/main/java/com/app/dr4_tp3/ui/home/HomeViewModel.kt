package com.app.dr4_tp3.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
//     lateinit var anime: List<Anime>
//
//    fun setupRecycleView(
//        recycleView: RecyclerView, context: Context
//    ) {
//
//        //progressBar.visibility = View.VISIBLE
//
//
//            recycleView.adapter = AnimesAdpter(anime,this::callbackListaAnimes)
//            recycleView.layoutManager = LinearLayoutManager(context)
//
//
//    }


//    fun callbackListaAnimes(anime: Anime, view: View, context: Context ) {
//
//        val nome_anime = anime.nomeAnime.toString()
//
//        ApiClient.getAnimesService()
//            .show(nome_anime)
//            .enqueue(object : Callback<List<AnimeList>> {
//                override fun onFailure(call: Call<List<AnimeList>>, t: Throwable) {
//                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
//                    Log.e("ERROAPI", t.message)
//                }
//
//                override fun onResponse(
//                    call: Call<List<AnimeList>>,
//                    response: Response<List<AnimeList>>
//                ) {
//                    val lista = response.body()
//                    var achou = false
//
//                    lista!!.forEach {
//                        it.data.forEach{
//                            view.txtNomeAnime.setText(it?.slug)
//                            achou = true
//
//                            return
//                        }
//
//                    }
//
//                }
//            })
//    }

//    fun listaMunicipiosAutoComplete(
//        context: Context,
//        acMunicipios: Anime
//    ) {
//        ApiClient.getAnimesService().show()
//            .enqueue(object : Callback<List<AnimeList>> {
//                override fun onFailure(call: Call<List<AnimeList>>, t: Throwable) {
//                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
//
//                }
//
//                override fun onResponse(
//                    call: Call<List<AnimeList>>,
//                    response: Response<List<AnimeList>>
//                ) {
//                    val listaMunicipios = response.body()
//                    val municipios: MutableList<String> = mutableListOf()
//                    listaMunicipios?.forEach {
//                        municipios.add(it.slug.toString())
//                    }
//
//                    if(municipios.isNotEmpty()){
//
//                        val adapter = ArrayAdapter(
//                            context,
//                            android.R.layout.simple_spinner_dropdownitem,
//                            municipios
//                        )
//
//                        acMunicipios.setAdapter(adapter)
//                        acMunicipios.threshold = 1
//                        acMunicipios.text.toString()
//
//                        acMunicipios.setOnDismissListener {
//                        }
//                        acMunicipios.onFocusChangeListener = View.OnFocusChangeListener { , b ->
//                            if (b) {
//                                // Sugestões dropdown
//                                acMunicipios.showDropDown()
//                            }
//                        }
//                    }
//
//
//                }
//            })
//    }
}


