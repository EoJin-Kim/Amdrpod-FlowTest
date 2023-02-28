package com.ej.flowtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ej.flow.repeatOnStarted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repeatOnStarted {
            viewModel.eventFlow.collect{ event ->
                handelEvent(event)
            }
        }
        viewModel.getProduct()




    }

    private fun handelEvent(event: MainViewModel.Event) {
        when (event) {
            is MainViewModel.Event.ShowProducts -> {
                Toast.makeText(this, "showProduct", Toast.LENGTH_SHORT).show()
                val text = findViewById<TextView>(R.id.text)
                val product = event.product
                text.text = product.toString()
            }
            is MainViewModel.Event.ProductError -> {
                Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show()
                val text = findViewById<TextView>(R.id.text)
                text.text = event.message
            }

            is MainViewModel.Event.ShowCart -> {

            }
        }
    }


}