package com.master8.expuiobservedata.rx

import android.util.Log
import androidx.lifecycle.ViewModel

class RxViewModel : ViewModel() {

    init {
        Log.e("mv8", "view model init")
    }

    val data = loadStubData()
}

