package com.kodextech.elleapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kodextech.elleapp.R
import java.io.Serializable

class CreativeBlogListAdapter (
    val context: Context,
    val blogsList: ArrayList<BlogCategoryListModel>,
    val callBack: ((position: Int) -> Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.blog_listing_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            callBack(position)
            notifyDataSetChanged()
        }

        val typeAllCategory = blogsList[position]
        val blogIcon = holder.itemView.findViewById<ImageView>(R.id.blogIcon)
        val tvblogTitle = holder.itemView.findViewById<TextView>(R.id.tvblogTitle)
        val tvblogReadTime = holder.itemView.findViewById<TextView>(R.id.tvblogReadTime)



        blogIcon.setImageResource(typeAllCategory.categoryDrawable)
        tvblogTitle.text = typeAllCategory.blogTitle
        tvblogReadTime.text = typeAllCategory.blogRead

    }

    override fun getItemCount() = blogsList.size
}

class BlogCategoryListModel (
    var blogTitle:String, var blogRead:String, var categoryDrawable:Int
): Serializable
