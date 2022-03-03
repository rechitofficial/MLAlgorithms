package com.rechit.mlalgorithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rechit.mlalgorithms.databinding.ActivityMachineLearningAppBinding

class MachineLearningAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMachineLearningAppBinding
    private lateinit var rvApp: RecyclerView
    private val list = ArrayList<App>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMachineLearningAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Adding RecyclerView
        rvApp = findViewById(R.id.rv_app)
        rvApp.setHasFixedSize(true)
        //-----------------------------//

        list.addAll(listApp)
        showRecyclerList()
    }

    private val listApp: ArrayList<App>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataIcon = resources.obtainTypedArray(R.array.data_icon)
            val listApp = ArrayList<App>()
            for (i in dataName.indices) {
                val hero = App(dataName[i],dataDescription[i], dataIcon.getResourceId(i, -1))
                listApp.add(hero)
            }
            return listApp
        }

    private fun showRecyclerList() {
        rvApp.layoutManager = LinearLayoutManager(this)
        val listAppAdapter = ListAppAdapter(list)
        rvApp.adapter = listAppAdapter
    }
}