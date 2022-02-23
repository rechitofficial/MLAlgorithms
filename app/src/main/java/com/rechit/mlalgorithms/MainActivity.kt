package com.rechit.mlalgorithms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_regression)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_regression -> {
                val btnName: Button = findViewById(R.id.btn_regression)

                val moveIntent = Intent(this@MainActivity, RegressionActivity::class.java)
                //move object with data
                moveIntent.putExtra(RegressionActivity.EXTRA_NAME, btnName.text.toString())
                //move object with parcelable
                val type1 = RegressionTypes(
                    "Linear Regression",
                    "Linear regression is a linear approach to modelling the relationship between a dependent variable and one or more independent variable, given data all you need is to predict y to create line y = mx + c with minimal loss function that is using least square formula"
                )
                // val type2 coming soon
                moveIntent.putExtra(RegressionActivity.EXTRA_TYPE_NAME, type1)
                moveIntent.putExtra(RegressionActivity.EXTRA_TYPE_DEFINITION, type1)

                startActivity(moveIntent)
            }
        }
    }
}