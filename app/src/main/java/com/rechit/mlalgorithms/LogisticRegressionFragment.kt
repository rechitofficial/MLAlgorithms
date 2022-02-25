package com.rechit.mlalgorithms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class LogisticRegressionFragment : Fragment() {

    private lateinit var tvTypeRegression: TextView
    private lateinit var tvTypeDefinition: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logistic_regression, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvTypeRegression = view.findViewById(R.id.tv_type_regression)
        tvTypeDefinition = view.findViewById(R.id.tv_type_definition)
        super.onViewCreated(view, savedInstanceState)
    }

}