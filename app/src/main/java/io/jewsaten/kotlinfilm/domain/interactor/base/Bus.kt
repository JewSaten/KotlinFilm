package io.jewsaten.kotlinfilm.domain.interactor.base

interface Bus {
    fun post(event: Any)
    fun register(observer: Any)
    fun unregister(observer: Any)
}