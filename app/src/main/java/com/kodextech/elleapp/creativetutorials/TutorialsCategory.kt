package com.kodextech.elleapp.creativetutorials


import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodextech.elleapp.R
import com.kodextech.elleapp.adapters.VideoCategoryAdapter
import com.kodextech.elleapp.adapters.VideoCatgoryModel
import com.kodextech.elleapp.base.BaseActivity
import com.kodextech.elleapp.dashboard.Dashboard
import com.kodextech.elleapp.utils.showToast
import kotlinx.android.synthetic.main.activity_tutorials_category.*
import kotlinx.android.synthetic.main.headercategories.*
import kotlinx.android.synthetic.main.headercategories.ivBackCategories
import java.util.ArrayList

class TutorialsCategory : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentVideoCategory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_tutorials_category)
        super.onCreate(savedInstanceState)

        setupAllCategoriesRecycler()

        ivBackTutorialCategories.setOnClickListener {
            startActivity(Intent(this@TutorialsCategory,Dashboard::class.java))
        }


    }
    private fun setupAllCategoriesRecycler(){
        val allCategoryRecycler = findViewById<RecyclerView>(R.id.rvCategoriesTutorials)
        val llAllCategoryManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL,false)
        allCategoryRecycler.layoutManager = llAllCategoryManager
        val allCategoryList = ArrayList<VideoCatgoryModel>()
        allCategoryList.add(VideoCatgoryModel("Paintings",R.drawable.gallery))
        allCategoryList.add(VideoCatgoryModel("Art",R.drawable.gallery))
        allCategoryList.add(VideoCatgoryModel("Beauty",R.drawable.gallery))
        allCategoryList.add(VideoCatgoryModel("Cooking",R.drawable.gallery))
        allCategoryList.add(VideoCatgoryModel("Modeling",R.drawable.gallery))


        allCategoryRecycler.adapter = VideoCategoryAdapter(this, allCategoryList, { position ->
            showToast(allCategoryList[position].categoryTitle.toString())
            when(allCategoryList[position].categoryTitle){

                "Paintings" ->{
                    val intent = Intent(this@TutorialsCategory, CreativeVideos::class.java)
                    intent.putExtra("category","Paintings")
                    startActivity(intent)
                }
                "Art" ->{
                    val intent = Intent(this@TutorialsCategory, CreativeVideos::class.java)
                    intent.putExtra("category","Art")
                    startActivity(intent)
                }
                "Beauty" ->{
                    val intent = Intent(this@TutorialsCategory, CreativeVideos::class.java)
                    intent.putExtra("category","Beauty")
                    startActivity(intent)
                }
                "Cooking" ->{
                    val intent = Intent(this@TutorialsCategory, CreativeVideos::class.java)
                    intent.putExtra("category","Cooking")
                    startActivity(intent)
                }
                "Modeling" ->{
                    val intent = Intent(this@TutorialsCategory, CreativeVideos::class.java)
                    intent.putExtra("category","Modeling")
                    startActivity(intent)
                }
            }
            allCategoryRecycler.adapter?.notifyDataSetChanged()
        })

    }
}