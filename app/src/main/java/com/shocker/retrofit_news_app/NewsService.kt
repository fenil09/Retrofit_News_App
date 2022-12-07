package com.shocker.retrofit_news_app

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BaseUrl="https://newsapi.org/"
const val APIKEY="c01d0d1a0a9448e394299c44da45c01c"
interface News{
@GET("/v2/top-headlines?apikey=$APIKEY")
fun getheadlines(@Query("country") country:String,@Query("page")page:Int):Call<news>
}


object NewsService{
    val newsinstace:News
    
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstace=retrofit.create(News::class.java)
    }

   
    
}