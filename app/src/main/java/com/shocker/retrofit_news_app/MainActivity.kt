package com.shocker.retrofit_news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getnews()
    }

    fun getnews(){
        val news=NewsService.newsinstace.getheadlines("in",1)
        news.enqueue(object:Callback<news>{
            override fun onResponse(call: Call<news>, response: Response<news>) {
                val data=response.body()
                if (data != null) {
                 Log.d("fenil1",data.toString())
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