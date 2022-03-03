package com.rechit.mlalgorithms

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvMachineLearning: TextView
    private lateinit var tvAnswer: TextView
    private lateinit var btnCustom: CustomViewButton

//    private lateinit var myCustomButton: CustomViewButton
//    private lateinit var myEditText: CustomEditText

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == QuestionActivity.RESULT_CODE && result.data != null){
            val pickedValue = result.data?.getStringExtra(QuestionActivity.EXTRA_SELECTED_VALUE)
            tvAnswer.text = pickedValue
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_regression)
        val btnAddNote: Button = findViewById(R.id.btn_addNote)
        val btnQuestion: Button = findViewById(R.id.btn_question)
        tvAnswer = findViewById(R.id.tv_answer)
        tvMachineLearning = findViewById(R.id.tv_machineLearning)
        btnCustom = findViewById(R.id.btn_custom)
        btnMoveActivity.setOnClickListener(this)
        btnAddNote.setOnClickListener(this)
        btnQuestion.setOnClickListener(this)
        tvMachineLearning.setOnClickListener(this)
        btnCustom.setOnClickListener(this)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_regression -> {
                val btnName: Button = findViewById(R.id.btn_regression)

                val moveIntent = Intent(this@MainActivity, RegressionActivity::class.java)
                //move object with data
                moveIntent.putExtra(RegressionActivity.EXTRA_NAME, btnName.text.toString())
                //move object with parcelable
                val type1 = AlgorithmTypes(
                    "Regression",
                    "Regression is a linear approach to modelling the relationship between a dependent variable and one or more independent variable, given data all you need is to predict y to create line y = mx + c with minimal loss function that is using least square formula"
                )
                // val type2 coming soon
                //moveIntent.putExtra(RegressionActivity.EXTRA_TYPE_NAME, type1)
                moveIntent.putExtra(RegressionActivity.EXTRA_DEFINITION, type1)
                startActivity(moveIntent)
            }
            R.id.btn_addNote -> {
                /*
                val subject = "Subject"
                val text = "Add your note here"
                val noteIntent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
                    putExtra(NoteIntents.EXTRA_NAME, subject)
                    putExtra(NoteIntents.EXTRA_TEXT, text)
                }
                if(noteIntent.resolveActivity(packageManager) != null){
                    startActivity(noteIntent)
                }
                 */
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_question -> {
                val moveForResultIntent = Intent(this@MainActivity, QuestionActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.tv_machineLearning -> {
                val moveIntent = Intent(this@MainActivity, MachineLearningActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_custom -> {
                val moveIntent = Intent(this, MachineLearningAppActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}