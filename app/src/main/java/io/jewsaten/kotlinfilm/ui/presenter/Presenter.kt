package io.jewsaten.kotlinfilm.ui.presenter

import io.jewsaten.kotlinfilm.domain.interactor.base.Bus
import io.jewsaten.kotlinfilm.domain.interactor.base.Interactor
import io.jewsaten.kotlinfilm.domain.interactor.base.InteractorPriority

/**
 * Created by Administrator on 2018/3/28.
 */
interface Presenter<out T> {

    val view: T

    val bus: Bus

    fun onResume(){
        bus.register(this)
    }

    fun onPause(){
        bus.unregister(this)
    }
}