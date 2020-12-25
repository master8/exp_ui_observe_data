package com.master8.expuiobservedata.rx

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject

class StableFlowable<T>(
    private val dataFlowable: Flowable<T>
) {

    private val _state = BehaviorSubject.create<T>()

    fun subscribe(lifecycle: Lifecycle, action: (value: T) -> Unit) {
        val provider = AndroidLifecycleScopeProvider.from(lifecycle)

        _state
            .toFlowable(BackpressureStrategy.LATEST)
            .`as`(AutoDispose.autoDisposable(provider))
            .subscribe(action)

        dataFlowable
            .`as`(AutoDispose.autoDisposable(provider))
            .subscribe { _state.onNext(it) }
    }
}

fun <T> Flowable<T>.asStableFlowable(): StableFlowable<T> {
    return StableFlowable(this)
}

fun Fragment.runOnUIThread(action: () -> Unit) {
    requireActivity().runOnUiThread(action)
}