package com.rechit.mlalgorithms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

//implementation of resultActivity

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnPick: Button
    private lateinit var rgQuestion: RadioGroup
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        btnPick = findViewById(R.id.btn_pick)
        rgQuestion = findViewById(R.id.rg_question)
        btnPick.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        val rgAnswer1: RadioButton = findViewById(R.id.rg_answer1)
        val rgAnswer2: RadioButton = findViewById(R.id.rg_answer2)
        val rgAnswer3: RadioButton = findViewById(R.id.rg_answer3)
        val rgAnswer4: RadioButton = findViewById(R.id.rg_answer4)
        if(p0?.id == R.id.btn_pick){
            if(rgQuestion.checkedRadioButtonId > 0){
                var answer = ""

                when(rgQuestion.checkedRadioButtonId) {
                    R.id.rg_answer1 -> answer = rgAnswer1.text.toString()
                    R.id.rg_answer2 -> answer = rgAnswer2.text.toString()
                    R.id.rg_answer3 -> answer = rgAnswer3.text.toString()
                    R.id.rg_answer4 -> answer = rgAnswer4.text.toString()
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, answer)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}