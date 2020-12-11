package com.app.wikiapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.wikiapp.R
import com.app.wikiapp.data.AppModel
import com.bumptech.glide.Glide

class ArticleAdapter(var context : Context) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var dataList = emptyList<AppModel>()

    internal fun setDataList(dataList : List<AppModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var image : ImageView
        var title : TextView

        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.title)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            setOnClickListener.setOnProductItemClickListener(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.layout_article, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList.get(position);
        holder.title.text = data.title
    }

    interface SetOnClickListener {
        fun setOnProductItemClickListener(position : Int)
    }

    fun setProductOnClickListener(clickListener : SetOnClickListener) {
        setOnClickListener = clickListener
    }

    companion object {
        private lateinit var setOnClickListener: SetOnClickListener
    }
}