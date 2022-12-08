package com.shocker.retrofit_news_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapater(val context:Context,val articles:List<articles>):
    RecyclerView.Adapter<NewsAdapater.articleviewHolder>() {

    class articleviewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        val imageholder=itemview.findViewById<ImageView>(R.id.imageView)
        val titleholder=itemview.findViewById<TextView>(R.id.textView2)
        val descriptionholder=itemview.findViewById<TextView>(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): articleviewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.view,parent,false)
        return articleviewHolder(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    override fun onBindViewHolder(holder: articleviewHolder, position: Int) {
        val data=articles[position]
        holder.titleholder.text=data.title
        holder.descriptionholder.text=data.description
        Glide.with(context).load(data.urlToImage).into(holder.imageholder)
    }
}