package io.jewsaten.kotlinfilm.domain.interactor

import io.jewsaten.kotlinfilm.domain.interactor.base.Event
import io.jewsaten.kotlinfilm.domain.interactor.base.Interactor
import io.jewsaten.kotlinfilm.domain.interactor.event.FilmsEvent
import io.jewsaten.kotlinfilm.ui.entity.FilmDetail

/**
 * Created by Administrator on 2018/3/29.
 */
class GetFilmsInteractor(val films : List<FilmDetail>) : Interactor {

    override fun invoke(): Event {
        return FilmsEvent(films)
    }
}