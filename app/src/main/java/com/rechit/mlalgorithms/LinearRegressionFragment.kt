package com.rechit.mlalgorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class LinearRegressionFragment : Fragment(), View.OnClickListener {
    private lateinit var edtX: EditText
    private lateinit var edtY: EditText
    private lateinit var tvResult: TextView
//    private lateinit var tvTypeRegression: TextView  (already changed with toolbar)
    private lateinit var tvTypeDefinition: TextView

    var name: String? = null
    var definition: String? = null

    companion object {
        private const val STATE_RESULT = "state_result"
        const val EXTRA_TYPE_NAME = "extra_type"
        const val EXTRA_TYPE_DEFINITION = "extra_type_definition"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_regression, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edtX = view.findViewById(R.id.edt_x)
        edtY = view.findViewById(R.id.edt_y)
        val btnCalculate: Button = view.findViewById(R.id.btn_calculate)
        tvResult = view.findViewById(R.id.tv_result)
//        tvTypeRegression = view.findViewById(R.id.tv_type_regression)
        tvTypeDefinition = view.findViewById(R.id.tv_type_definition)



        btnCalculate.setOnClickListener(this)

        // get data from RegressionActivity using AlgorithmTypes class
        if(savedInstanceState!= null){
            val definitionFromBundle = savedInstanceState.getString(EXTRA_TYPE_DEFINITION)
            definition = definitionFromBundle
        }

        if(arguments!= null){
            val typeName = arguments?.getString(EXTRA_TYPE_NAME)
//            tvTypeRegression.text = typeName
            tvTypeDefinition.text = definition

            // Change default action bar to toolbar by moving intent with data
            (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.toolbar_linearRegression))
            (activity as AppCompatActivity).supportActionBar?.title = typeName
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