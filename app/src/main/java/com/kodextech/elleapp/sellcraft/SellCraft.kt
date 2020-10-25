package com.kodextech.elleapp.sellcraft


import android.content.Intent
import android.os.Bundle
import com.kodextech.elleapp.R
import com.kodextech.elleapp.base.BaseActivity
import com.kodextech.elleapp.blogs.BlogDetails
import com.kodextech.elleapp.utils.showToast
import kotlinx.android.synthetic.main.activity_sell_craft.*


class SellCraft : BaseActivity() {
    override fun onSetupViewGroup() {
        mViewGroup = findViewById(R.id.contentSellCraft)
    }

    lateinit var rawCostFinal:String
    lateinit var empCostFinal:String

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sell_craft)
        super.onCreate(savedInstanceState)



        bntCalculate.setOnClickListener {
            calculate()
        }


        bntNextSellCraft.setOnClickListener{
            calculate()
            val intent = Intent(this@SellCraft, SellNow::class.java)
            intent.putExtra("raw",rawCostFinal)
            intent.putExtra("emp",empCostFinal)
            intent.putExtra("profit",etProfit.text.toString())
            startActivity(intent)
        }
    }

    private fun calculate() {
        if(etProductName.text.toString().isEmpty()
            || etProductQuantity.text.toString().isEmpty()
            ||etProductUnitPrice.text.toString().isEmpty()){
            showToast("Please Fill Mandatory Product Details")
        }
        else {
            var productQuantity:Int = Integer.parseInt(etProductQuantity.text.toString())
            var productUnitPrice:Float = etProductQuantity.text.toString().toFloat()
            var extraCost:Float = etProductExtraCost.text.toString().toFloat()
            var rawPrice:Float = (productQuantity*productUnitPrice) + extraCost
            rawCostFinal = rawPrice.toString()
            tvRawCost.text = "Raw Cost: "+ rawPrice.toString()
        }
        if(etProductName.text.toString().isEmpty()
            || etProductQuantity.text.toString().isEmpty()
            ||etProductUnitPrice.text.toString().isEmpty()){
            showToast("Please Fill Mandatory Employee Details")
        }
        else {
            var empSalary:Int = Integer.parseInt(etEmployeeSalary.text.toString())
            var noOfDaysWorked:Int = Integer.parseInt(etEmployeedaysworked.text.toString())
            var empExtraPay:Float = etEMployeeExtraPay.text.toString().toFloat()
            var perdaySalary: Int = empSalary/noOfDaysWorked
            var empCost:Float = (perdaySalary*noOfDaysWorked) + empExtraPay
            empCostFinal = empCost.toString()
            tvEmpCost.text = "Emp Cost: "+ empCost.toString()
        }
    }
}