package com.master8.expuiobservedata.rx

import android.util.Log
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

fun loadStubData(): Flowable<Long> = Flowable.interval(0, 1000, TimeUnit.MILLISECONDS)
    .doOnNext { Log.e("mv8", "e $it") }