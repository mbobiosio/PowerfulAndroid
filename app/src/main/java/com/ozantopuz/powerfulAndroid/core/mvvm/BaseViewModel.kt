package com.ozantopuz.powerfulAndroid.core.mvvm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.ozantopuz.powerfulAndroid.core.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseViewModel: ViewModel(), com.ozantopuz.powerfulAndroid.core.mvvm.ViewModel {

    private var lifecycle: Lifecycle? = null

    @Inject
    lateinit var schedulers: SchedulerProvider

    val disposeBag: CompositeDisposable = CompositeDisposable()


    override fun attachView(lifecycle: Lifecycle) {
        this.lifecycle = lifecycle
        onViewAttached()
    }

    @Synchronized
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected fun onViewDestroyed() {
        clearDisposeBag()
        lifecycle = null
    }

    abstract fun onViewAttached()

    override fun onCleared() {
        clearDisposeBag()
        super.onCleared()
    }

    private fun clearDisposeBag() {
        disposeBag.clear()
    }
}