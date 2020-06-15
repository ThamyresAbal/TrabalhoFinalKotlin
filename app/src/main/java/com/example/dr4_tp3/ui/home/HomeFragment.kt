package com.example.dr4_tp3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dr4_tp3.R
import com.example.dr4_tp3.adpter.AnimesAdpter
import com.example.dr4_tp3.apiService.ApiClient
import com.example.dr4_tp3.model.AnimeList
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            homeViewModel = ViewModelProviders.of(it).get(HomeViewModel::class.java)
        }
        ApiClient.getAnimesService().all().enqueue(object : Callback<AnimeList> {
            override fun onFailure(call: Call<AnimeList>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<AnimeList>, response: Response<AnimeList>) {
                val listaBairros = response.body()
                val slugList: MutableList<String> = mutableListOf()

                listaBairros?.data?.forEach {
                    slugList.add(it.attributes.slug)
                }


                val linearLayoutManager = LinearLayoutManager(requireContext())
                rcyViewAnimes.layoutManager = linearLayoutManager
                rcyViewAnimes.scrollToPosition(slugList.size)
                rcyViewAnimes.adapter =
                    AnimesAdpter(slugList)



            }


        })

    }
}
