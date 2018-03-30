package io.jewsaten.kotlinfilm.domain.interactor.base

interface Interactor {

    operator fun invoke(): Event
}