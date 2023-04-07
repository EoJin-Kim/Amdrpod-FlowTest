package com.ej.flowtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ej.flow.MutableEventFlow
import com.ej.flow.SharedFlowBus
import com.ej.flow.asEventFlow
import com.ej.network.ApiState
import com.ej.network.NetworkRepository
import com.ej.network.dto.Cart
import com.ej.network.dto.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val flow = SharedFlowBus.getFlow()
    private val repository = NetworkRepository()

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            flow!!.emit("dsfadsfdsf")
        }
    }
    fun getProduct() {
        viewModelScope.launch {
            repository.getProducts()
                .catch {

                }.collect{
                    when (it) {
                        is ApiState.Loading ->{

                        }
                        is ApiState.Success ->{
                            _eventFlow.emit(Event.ShowProducts(it.data!!))
                        }
                        is ApiState.Error ->{
                            _eventFlow.emit(Event.ProductError(it.message!!))
                        }
                    }
                }

        }
    }

    fun test() {

    }


    sealed class Event {
        data class ShowProducts(val product: Product) : Event()
        data class ProductError(val message : String) : Event()
        data class ShowCart(val cart: Cart) : Event()
    }
}