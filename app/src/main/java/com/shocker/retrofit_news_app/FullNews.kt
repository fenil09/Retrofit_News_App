package com.shocker.retrofit_news_app

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FullNews : AppCompatActivity() {
    lateinit var imagedata:ImageView
    lateinit var textdata:TextView
    lateinit var contentdata:TextView
    lateinit var urlholder:TextView
    var position:Int=0
    var urldata:String=""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)
        imagedata=findViewById(R.id.imageView7)
        textdata=findViewById(R.id.textView7)
        contentdata=findViewById(R.id.textView8)
        urlholder=findViewById(R.id.textView9)
        val intent=intent
         position=intent.getIntExtra("data1",0)
         urldata= intent.getStringExtra("dataurl").toString()

        getnews()
    }

    fun getnews(){
        val news=NewsService.newsinstace.getheadlines("in",1)
        news.enqueue(object:Callback<news>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<news>, response: Response<news>) {
                val data=response.body()
                if(data!=null){
                    val title=data.articles[position].title
                    textdata.text=title
                    val content=data.articles[position].content
                    contentdata.text=content
                    val uri=data.articles[position].url
                    var headdata="Check out the full news -> "
                    urlholder.text=headdata+uri.toUri()
                    Glide.with(this@FullNews).load(urldata).into(imagedata)
                }
            }

            override fun onFailure(call: Call<news>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}