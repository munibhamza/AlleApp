package com.kodextech.elleapp.blogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodextech.elleapp.R
import com.kodextech.elleapp.adapters.BlogCategoryListModel
import com.kodextech.elleapp.adapters.CreativeBlogListAdapter
import com.kodextech.elleapp.adapters.VideoCategoryAdapter
import com.kodextech.elleapp.adapters.VideoCatgoryModel
import com.kodextech.elleapp.base.BaseActivity
import com.kodextech.elleapp.utils.showToast
import kotlinx.android.synthetic.main.activity_creative_blog.*
import kotlinx.android.synthetic.main.activity_creative_videos.*
import kotlinx.android.synthetic.main.activity_creative_videos.tvVideoCategoryTitle
import kotlinx.android.synthetic.main.headercategories.*
import java.util.ArrayList

class CreativeBlog : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentCreativeBlog)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_creative_blog)
        super.onCreate(savedInstanceState)


        val blogCategoryTitle=intent.getStringExtra("category")
        tvBlogCategoryTitle.text = blogCategoryTitle


        setupAllBlogsRecycler()

        ivBackCreativeBlog.setOnClickListener {
            startActivity(Intent(this@CreativeBlog, BlogsCategory::class.java))
        }
    }

    private fun setupAllBlogsRecycler(){
        val allCategoryRecycler = findViewById<RecyclerView>(R.id.rvCreativeBlogsList)
        val llAllCategoryManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL,false)
        allCategoryRecycler.layoutManager = llAllCategoryManager
        val allBlogList = ArrayList<BlogCategoryListModel>()
        allBlogList.add(BlogCategoryListModel("Paintings","6 minutes read",R.drawable.blogiconleft))
        allBlogList.add(BlogCategoryListModel("Art","6 minutes read",R.drawable.blogiconleft))
        allBlogList.add(BlogCategoryListModel("Beauty","6 minutes read",R.drawable.blogiconleft))
        allBlogList.add(BlogCategoryListModel("Cooking","6 minutes read",R.drawable.blogiconleft))
        allBlogList.add(BlogCategoryListModel("Modeling","6 minutes read",R.drawable.blogiconleft))


        allCategoryRecycler.adapter = CreativeBlogListAdapter(this, allBlogList, { position ->
            showToast(allBlogList[position].blogTitle.toString())
            when(allBlogList[position].blogTitle){

                "Paintings" ->{
                    val intent = Intent(this@CreativeBlog, CreativeBlog::class.java)
                    intent.putExtra("category","Paintings")
                    startActivity(intent)
                }
                "Art" ->{
                    val intent = Intent(this@CreativeBlog, CreativeBlog::class.java)
                    intent.putExtra("category","Art")
                    startActivity(intent)
                }
                "Beauty" ->{
                    val intent = Intent(this@CreativeBlog, CreativeBlog::class.java)
                    intent.putExtra("category","Beauty")
                    startActivity(intent)
                }
                "Cooking" ->{
                    val intent = Intent(this@CreativeBlog, CreativeBlog::class.java)
                    intent.putExtra("category","Cooking")
                    startActivity(intent)
                }
                "Modeling" ->{
                    val intent = Intent(this@CreativeBlog, CreativeBlog::class.java)
                    intent.putExtra("category","Modeling")
                    startActivity(intent)
                }
            }
            allCategoryRecycler.adapter?.notifyDataSetChanged()
        })

    }
}