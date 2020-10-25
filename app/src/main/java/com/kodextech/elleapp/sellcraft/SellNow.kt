package com.kodextech.elleapp.sellcraft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.kodextech.elleapp.R
import com.kodextech.elleapp.base.BaseActivity
import com.kodextech.elleapp.dashboard.Dashboard
import com.kodextech.elleapp.utils.showToast
import kotlinx.android.synthetic.main.activity_creative_blog.*
import kotlinx.android.synthetic.main.activity_sell_now.*

class SellNow : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentSellNow)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sell_now)
        super.onCreate(savedInstanceState)

        val rawPrice=intent.getStringExtra("raw")
        val empPrice=intent.getStringExtra("emp")
        val profitPrice=intent.getStringExtra("profit")
        val computedPrice:Float  = rawPrice.toString().toFloat()+ empPrice.toString().toFloat() + profitPrice.toString().toFloat()

        tvRawCostFinal.setText(rawPrice)
        tvEmpCostFinal.setText(empPrice)


        tvComputedPrice.setText(computedPrice.toString())
        bntSellNow.setOnClickListener{
            if(quantityToSell.text.toString().isEmpty()){
                showToast("Please enter quantity to sell")
            }else{
            showToast("You will be contacted soon")
            startActivity(Intent(this@SellNow,Dashboard::class.java))
        }
        }

        totalProfit.setOnClickListener {
            if (quantityToSell.text.toString().isEmpty()){
            showToast("Please enter quantity to sell")
        }else{
            totalProfit.setOnClickListener {
                var tProfit:Float = quantityToSell.text.toString().toFloat()*profitPrice.toString().toFloat()
                totalProfit.setText(tProfit.toString())
            }
        } }



    }

}

