package com.rechit.mlalgorithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rechit.mlalgorithms.databinding.ActivityMachineLearningBinding

class MachineLearningActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMachineLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineLearningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_machine_learning)


    }
}