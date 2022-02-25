package com.rechit.mlalgorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class RegressionTypesFragment : Fragment(), View.OnClickListener {

    private lateinit var btnLinearRegression: Button
    private lateinit var btnLogisticRegression: Button
    private lateinit var btnPolynomialRegression: Button
    private lateinit var btnSupportVectorRegression: Button
    private lateinit var btnDesicionTreeRegression: Button
    private lateinit var btnRandomForestRegression: Button
    private lateinit var btnRidgeRegression: Button
    private lateinit var btnLassoRegression: Button

    companion object {
        const val EXTRA_TYPE_NAME = "extra_type"
        const val EXTRA_TYPE_DEFINITION = "extra_type_definition"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regression_types, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLinearRegression = view.findViewById(R.id.btn_linearRegression)
        btnLogisticRegression = view.findViewById(R.id.btn_logisticRegression)
        btnPolynomialRegression = view.findViewById(R.id.btn_polynomialRegression)
        btnSupportVectorRegression = view.findViewById(R.id.btn_supportVectorRegression)
        btnDesicionTreeRegression = view.findViewById(R.id.btn_desicionTreeRegression)
        btnRandomForestRegression = view.findViewById(R.id.btn_randomForestRegression)
        btnRidgeRegression = view.findViewById(R.id.btn_ridgeRegression)
        btnLassoRegression = view.findViewById(R.id.btn_lassoRegression)

        // Change default action bar to toolbar by moving intent with data
        (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.regression_toolbar))
        val name = (activity as AppCompatActivity).intent.getStringExtra(EXTRA_TYPE_NAME)
        (activity as AppCompatActivity).supportActionBar?.title = name

        btnLinearRegression.setOnClickListener(this)
        btnLogisticRegression.setOnClickListener(this)
        btnPolynomialRegression.setOnClickListener(this)
        btnSupportVectorRegression.setOnClickListener(this)
        btnDesicionTreeRegression.setOnClickListener(this)
        btnRandomForestRegression.setOnClickListener(this)
        btnRidgeRegression.setOnClickListener(this)
        btnLassoRegression.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_linearRegression -> {
                val mLinearRegressionFragment = LinearRegressionFragment()

                // move data to LinearRegressionFragment through bundle
                val mBundle = Bundle()
                mBundle.putString(LinearRegressionFragment.EXTRA_TYPE_NAME, "Linear Regression")
                mLinearRegressionFragment.arguments = mBundle
                // move data to LinearRegressionFragment through getter and setter
                val definition = "Linear regression is a linear approach to modelling the relationship between a dependent variable and one or more independent variable, given data all you need is to predict y to create line y = mx + c with minimal loss function that is using least square formula"
                mLinearRegressionFragment.definition = definition

                //move to LinearRegressionFragment
                val mFragmentManager = parentFragmentManager
                mFragmentManager.beginTransaction().apply {
                    replace(R.id.fl_regressionTypes, mLinearRegressionFragment, mLinearRegressionFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }

}