package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var service: APIService

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RVAdapter(listOfItems) }

    private val listOfItems = arrayListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        service.getListOfUsers().enqueue(object : Callback<ArrayList<Data>> {
            override fun onResponse(p0: Call<ArrayList<Data>>, p1: Response<ArrayList<Data>>) {
                if (p1.isSuccessful) {
                    p1.body()?.let {
                        listOfItems.clear()
                        listOfItems.addAll(it)
                        adapter.notifyItemRangeInserted(0, listOfItems.size)
                    }
                } else {
                    onFailure(p0, Throwable())
                }
            }

            override fun onFailure(p0: Call<ArrayList<Data>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_LONG).show()
            }
        })

    }
}