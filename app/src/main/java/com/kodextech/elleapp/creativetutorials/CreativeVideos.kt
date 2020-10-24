package com.kodextech.elleapp.creativetutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.kodextech.elleapp.R
import com.kodextech.elleapp.adapters.VideoAdapter
import com.kodextech.elleapp.base.BaseActivity
import com.kodextech.elleapp.model.youTubeVideos
import kotlinx.android.synthetic.main.activity_creative_videos.*
import java.util.*

class CreativeVideos : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentcreativevideos)
    }


    private lateinit var recyclerView: RecyclerView
    private var youtubeVideos = Vector<youTubeVideos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_creative_videos)
        super.onCreate(savedInstanceState)

        ivBackVideos.setOnClickListener {
            startActivity(Intent(this@CreativeVideos,TutorialsCategory::class.java))
        }

        val videocategoryName=intent.getStringExtra("category")
        tvVideoCategoryTitle.text = videocategoryName


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        youtubeVideos.add(youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/X7SiuQxhAjg\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideos.add(youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/KyJ71G2UxTQ\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideos.add(youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/y8Rr39jKFKU\" frameborder=\"0\" allowfullscreen>lt;/iframe>"))
        youtubeVideos.add(youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/8Hg1tqIwIfI\" frameborder=\"0\" allowfullscreen></iframe>"))
        youtubeVideos.add(youTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www" +
                ".youtube.com/embed/uhQ7mh_o_cM\" frameborder=\"0\" allowfullscreen></iframe>"))
        val videoAdapter = VideoAdapter(youtubeVideos)
        recyclerView.adapter = videoAdapter


    }
}