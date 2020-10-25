package com.kodextech.elleapp.blogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodextech.elleapp.R
import kotlinx.android.synthetic.main.activity_blog_details.*

class BlogDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_details)

        ivBackblogDetails.setOnClickListener {
            startActivity(Intent(this@BlogDetails, BlogsCategory::class.java))
        }
        tvCancelBlog.setOnClickListener {
            startActivity(Intent(this@BlogDetails, BlogsCategory::class.java))
        }
    }
}