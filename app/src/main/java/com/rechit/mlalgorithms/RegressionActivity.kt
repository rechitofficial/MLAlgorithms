package com.rechit.mlalgorithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class RegressionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtX: EditText
    private lateinit var edtY: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regression)

        edtX = findViewById(R.id.edt_x)
        edtY = findViewById(R.id.edt_y)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_calculate) {
            val inputX = edtX.text.toString().trim()
            val inputY = edtY.text.toString().trim()

            var isFieldEmpty = false
            if(inputX.isEmpty()){
                isFieldEmpty = true
                edtX.error = "Field tidak boleh kosong"
            }

            if(inputY.isEmpty()){
                isFieldEmpty = true
                edtY.error = "Field tidak boleh kosong"
            }

            if(!isFieldEmpty){
                val arrInputX = inputX.split(",").toTypedArray();
                val arrInputY = inputY.split(",").toTypedArray();
                var meanX = 0
                var meanY = 0
                for(i in 0..arrInputX.size-1){
                    meanX += arrInputX[i].toInt()
                    meanY += arrInputY[i].toInt()
                }
                meanX/=arrInputX.size
                //arrInputX.forEach { i -> meanX += (meanX + i.toInt()) }
                //arrInputY.forEach { j -> meanY += (meanY + j.toInt()) / arrInputY.size }
                val result = leastSquare(arrInputX, arrInputY, meanX, meanY)
                tvResult.text = result.toString()
            }


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    private fun leastSquare(arrInputX: Array<String>, arrInputY: Array<String>, meanX: Int, meanY: Int) : Int{
        var m: Int
        var num = 0
        var den = 0
        for(i in 0..arrInputX.size-1){
            num += (arrInputX[i].toInt() - meanX)*(arrInputY[i].toInt() - meanY)
            den += (arrInputX[i].toFloat() - meanX.toFloat()).pow(2).toInt()
        }
        //ex input, x= 3,1  y = 2,4 result num = -2, den = 2
        m = num/den

        return m
    }
}