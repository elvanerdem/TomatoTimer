package com.elvanerdem.tomatotimer.ui.base

import androidx.lifecycle.ViewModel
import com.elvanerdem.tomatotimer.TomatoTimerApp
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class BaseViewModel: ViewModel() {

    protected var compositeDisposable = CompositeDisposable()

    @Inject
    protected lateinit var app: TomatoTimerApp


}