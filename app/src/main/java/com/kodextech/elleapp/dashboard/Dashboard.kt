package com.kodextech.elleapp.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodextech.elleapp.R
import com.kodextech.elleapp.blogs.BlogsCategory
import com.kodextech.elleapp.creativetutorials.TutorialsCategory
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        llCreativeTutorials.setOnClickListener {
            startActivity(Intent(this@Dashboard,TutorialsCategory::class.java))
        }
        llEntreBootcamp.setOnClickListener {
            startActivity(Intent(this@Dashboard,BlogsCategory::class.java))
        }
        llsellcraft.setOnClickListener {

        }
        llexploremore.setOnClickListener {

        }

    }
}