package com.master8.expuiobservedata.flow

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StableFLow<T>(
    private val dataFlow: Flow<T>
) {

    private val _stateFlow = MutableStateFlow<T?>(null)

    fun collect(lifecycleScope: LifecycleCoroutineScope, action: suspend (value: T) -> Unit) {
        lifecycleScope.launchWhenStarted {
            launch {
                dataFlow.collect { _stateFlow.value = it }
            }
        }

        lifecycleScope.launchWhenStarted {
            launch {
                _stateFlow.filterNotNull()
                    .collect(action)
            }
        }
    }
}

fun <T> Flow<T>.asStableFlow(): StableFLow<T> {
    return StableFLow(this)
}