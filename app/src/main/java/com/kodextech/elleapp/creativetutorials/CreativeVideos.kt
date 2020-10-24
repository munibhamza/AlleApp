package com.kodextech.elleapp.creativetutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kodextech.cleaques.base.BaseActivity
import com.kodextech.elleapp.R
import kotlinx.android.synthetic.main.activity_creative_videos.*

class CreativeVideos : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentcreativevideos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_creative_videos)
        super.onCreate(savedInstanceState)

        val videocategoryName=intent.getStringExtra("category")
        tvVideoCategoryTitle.text = videocategoryName


    }
}