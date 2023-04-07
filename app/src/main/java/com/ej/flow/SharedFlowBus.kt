package com.ej.flow

import kotlinx.coroutines.flow.MutableSharedFlow

class SharedFlowBus {

    companion object{

        private var flow: MutableSharedFlow<String>? = null
        fun getFlow(): MutableSharedFlow<String>? {
            if (flow == null) {
                flow = MutableSharedFlow<String>()
            }
            return flow
        }

        fun release() {
            flow = null
        }
    }

}