package com.master8.expuiobservedata.flow

import android.util.Log
import androidx.lifecycle.ViewModel

class FlowViewModel : ViewModel() {

    init {
        Log.e("mv8", "view model init")
    }

    val stableFLow = loadStubData()
        .asStableFlow()
}

