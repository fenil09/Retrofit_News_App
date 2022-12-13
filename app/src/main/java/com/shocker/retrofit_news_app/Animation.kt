package com.shocker.retrofit_news_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class Animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        val intent=intent
        val data=intent.getIntExtra("data",0)
        val urldata=intent.getStringExtra("url")
        val gotofullnews:Intent= Intent(this,FullNews::class.java)
        gotofullnews.putExtra("data1",data)
        gotofullnews.putExtra("dataurl",urldata)
        val timer=Timer()
        timer.schedule(2500){
            startActivity(gotofullnews)
            finish()
        }

    }
}