package io.jewsaten.kotlinfilm.domain.interactor.event

import io.jewsaten.kotlinfilm.ui.entity.FilmDetail
import io.jewsaten.kotlinfilm.domain.interactor.base.Event

data class FilmsEvent(val films: List<FilmDetail>) : Event