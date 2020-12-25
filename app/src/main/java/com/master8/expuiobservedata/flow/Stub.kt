package com.master8.expuiobservedata.flow

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun loadStubData(): Flow<Int> = flow<Int> {
    var i = 0
//    delay(5000)

    while (true) {
        emit(i)
        Log.e("mv8", "e $i")

        delay(1000)
        i++
    }
}