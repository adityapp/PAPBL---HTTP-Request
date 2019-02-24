package com.axce.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.axce.R
import com.axce.adapter.MovieAdapter
import com.axce.adapter.TokoAdapter
import com.axce.models.Movie
import com.axce.models.ResultsBean
import com.axce.models.Toko
import com.axce.utils.LahzadaService
import com.axce.utils.MovieService
import com.axce.utils.ServiceLahzada
import com.axce.utils.ServiceMovie
import kotlinx.android.synthetic.main.fragment_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ParentFragment : Fragment() {

    private lateinit var serviceLahzada: LahzadaService
    private lateinit var serviceMovie: MovieService
    private lateinit var baseUrl: String
    private lateinit var adapterLahzada: TokoAdapter
    private lateinit var adapterMovie: MovieAdapter
    private var dataSetLahzada = arrayListOf<Toko>()
    private var dataSetMovie = arrayListOf<ResultsBean>()
    private var filter = arrayListOf<Any>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)

        var status = activity?.intent?.getStringExtra("BUTTON")!!
        var ip = if (status.equals("local")) activity!!.intent.getStringExtra("IP") else ""

        val movieDb = "https://api.themoviedb.org/3/movie/"
        val local = "http://${ip}:3000/api/"
        Log.d("IP", local)
        baseUrl = if (status.equals("local")) local else movieDb

        if (status.equals("local")) {
            Log.d("STATUS", "Dari Local")
            adapterLahzada = TokoAdapter(context!!)
            serviceLahzada = ServiceLahzada(context!!, baseUrl).getApiService()
            getToko()
            adapterLahzada = TokoAdapter(context!!)
            adapterLahzada.dataSet = dataSetLahzada
        } else {
            Log.d("STATUS", "Dari Movie")
            adapterMovie = MovieAdapter(context!!)
            serviceMovie = ServiceMovie(context!!, baseUrl).getApiService()
            getMovie()
            adapterMovie = MovieAdapter(context!!)
            adapterMovie.dataSet = dataSetMovie
        }

        view.recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.recycler_view.adapter = if (status.equals("local")) adapterLahzada else adapterMovie

        view.edt_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter.clear()
                if (status.equals("local")){
                    dataSetLahzada.forEach {
                        if (it.nama.toLowerCase().contains(s.toString())) {
                            filter.add(it)
                        }
                    }
                    adapterLahzada.dataSet = filter as ArrayList<Toko>
                    adapterLahzada.notifyDataSetChanged()
                }else{
                    dataSetMovie.forEach {
                        if (it.title.toLowerCase().contains(s.toString())) {
                            filter.add(it)
                        }
                    }
                    adapterMovie.dataSet = filter as ArrayList<ResultsBean>
                    adapterMovie.notifyDataSetChanged()
                }
            }
        })

        return view
    }

    private fun getToko() {
        val result = serviceLahzada.getToko("application/json")
        result.enqueue(object :Callback<ArrayList<Toko>>{
            override fun onFailure(call: Call<ArrayList<Toko>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
                Log.e("ERROR", t.toString())
            }

            override fun onResponse(call: Call<ArrayList<Toko>>, response: Response<ArrayList<Toko>>) {
                try{
                    dataSetLahzada = response.body()!!
                    Log.d("CEK", response.body()!!.size.toString())
                    adapterLahzada.dataSet = dataSetLahzada
                    adapterLahzada.notifyDataSetChanged()
                }catch (e: Exception){
                    Log.e("ERROR", e.toString())
                }
            }

        })
    }

    private fun getMovie() {
        var result = serviceMovie.getMovie("now_playing?api_key=abdf48fd44cb74007720836ffe506983&language=en-US&page=1")
        result.enqueue(object : Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show()
                Log.e("ERROR", t.toString())
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                try {
                    var data = response.body()!!
                    dataSetMovie = data.results
                    adapterMovie.dataSet = dataSetMovie
                    Log.d("CEK", dataSetMovie.size.toString())
                    adapterMovie.notifyDataSetChanged()
                }catch (e: Exception) {
                    Log.e("ERROR", e.toString())
                }
            }
        })
    }

}
