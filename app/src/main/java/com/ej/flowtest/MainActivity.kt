package com.ej.flowtest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ej.flow.SharedFlowBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val txv = findViewById<TextView>(R.id.textView)
        val flow = SharedFlowBus.getFlow()
        viewModel.test()
        lifecycleScope.launchWhenStarted {
            flow!!
                .collect{
                    txv.text = it
                }
        }
        lifecycleScope.launchWhenStarted {
            flow!!
                .collect{
                    txv.text = it
                }
        }
        lifecycleScope.launchWhenStarted {
            flow!!
                .collect{
                    txv.text = it
                }
        }

    }

}