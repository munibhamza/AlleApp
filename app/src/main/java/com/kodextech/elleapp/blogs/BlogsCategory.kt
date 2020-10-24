package com.kodextech.elleapp.blogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodextech.cleaques.base.BaseActivity
import com.kodextech.cleaques.utils.showToast
import com.kodextech.elleapp.R
import com.kodextech.elleapp.adapters.VideoCategoryAdapter
import com.kodextech.elleapp.adapters.VideoCatgoryModel

import java.util.ArrayList

class BlogsCategory : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentblogscategory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_blogs_category)
        super.onCreate(savedInstanceState)

        setupAllBlogsRecycler()

    }

    private fun setupAllBlogsRecycler(){
        val allCategoryRecycler = findViewById<RecyclerView>(R.id.rvCategoriesblogs)
        val llAllCategoryManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL,false)
        allCategoryRecycler.layoutManager = llAllCategoryManager
        val allCategoryList = ArrayList<VideoCatgoryModel>()
        allCategoryList.add(VideoCatgoryModel("Paintings",R.drawable.ic_blog))
        allCategoryList.add(VideoCatgoryModel("Art",R.drawable.ic_blog))
        allCategoryList.add(VideoCatgoryModel("Beauty",R.drawable.ic_blog))
        allCategoryList.add(VideoCatgoryModel("Cooking",R.drawable.ic_blog))
        allCategoryList.add(VideoCatgoryModel("Modeling",R.drawable.ic_blog))


        allCategoryRecycler.adapter = VideoCategoryAdapter(this, allCategoryList, { position ->
            showToast(allCategoryList[position].categoryTitle.toString())
            when(allCategoryList[position].categoryTitle){

                "Paintings" ->{
                    val intent = Intent(this@BlogsCategory, CreativeBlog::class.java)
                    intent.putExtra("category","Paintings")
                    startActivity(intent)
                }
                "Art" ->{
                    val intent = Intent(this@BlogsCategory, CreativeBlog::class.java)
                    intent.putExtra("category","Art")
                    startActivity(intent)
                }
                "Beauty" ->{
                    val intent = Intent(this@BlogsCategory, CreativeBlog::class.java)
                    intent.putExtra("category","Beauty")
                    startActivity(intent)
                }
                "Cooking" ->{
                    val intent = Intent(this@BlogsCategory, CreativeBlog::class.java)
                    intent.putExtra("category","Cooking")
                    startActivity(intent)
                }
                "Modeling" ->{
                    val intent = Intent(this@BlogsCategory, CreativeBlog::class.java)
                    intent.putExtra("category","Modeling")
                    startActivity(intent)
                }
            }
            allCategoryRecycler.adapter?.notifyDataSetChanged()
        })

    }
}