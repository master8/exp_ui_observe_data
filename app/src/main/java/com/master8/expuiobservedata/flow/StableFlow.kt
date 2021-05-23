package com.master8.expuiobservedata.flow

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.*

class StableFLow<T>(
    private val dataFlow: Flow<T>
) {

    private val _stateFlow = MutableStateFlow<T?>(null)

    fun connectTo(lifecycleScope: LifecycleCoroutineScope): Flow<T> {
        lifecycleScope.launchWhenStarted {
            dataFlow.collect { _stateFlow.value = it }
        }
        return _stateFlow.filterNotNull()
    }
}

fun <T> Flow<T>.asStableFlow(): StableFLow<T> {
    return StableFLow(this)
}