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

class VideoCategoryAdapter (
    val context: Context,
    val allCategoryList: ArrayList<VideoCatgoryModel>,
    val callBack: ((position: Int) -> Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.category_tutorials_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            callBack(position)
            notifyDataSetChanged()
        }

        val typeAllCategory = allCategoryList[position]
        val tvCategoryTitle = holder.itemView.findViewById<TextView>(R.id.tvCategoryTitle)
        val ivCategoryImage = holder.itemView.findViewById<ImageView>(R.id.ivCategoryImage)

        tvCategoryTitle.text = typeAllCategory.categoryTitle
        ivCategoryImage.setImageResource(typeAllCategory.categoryDrawable)


    }

    override fun getItemCount() = allCategoryList.size
}

class VideoCatgoryModel (
    var categoryTitle:String, var categoryDrawable:Int
):Serializable
