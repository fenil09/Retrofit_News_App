package com.shocker.retrofit_news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapater: NewsAdapater
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycler1)
        getnews()

    }

    fun getnews(){
        val news=NewsService.newsinstace.getheadlines("in",1)
        news.enqueue(object:Callback<news>{
            override fun onResponse(call: Call<news>, response: Response<news>) {
                val data=response.body()
                if (data != null) {
                 adapater= NewsAdapater(this@MainActivity,data.articles)
                    recyclerView.adapter=adapater
                   recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                }
                else{
                    Log.d("fenil1","null")
                }
            }

            override fun onFailure(call: Call<news>, t: Throwable) {
               Log.d("fenil","Error occured while fetching the news",t)
            }

        })
    }
}