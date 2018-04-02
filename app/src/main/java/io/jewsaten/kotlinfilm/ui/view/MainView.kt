package io.jewsaten.kotlinfilm.ui.view

import io.jewsaten.kotlinfilm.ui.entity.FilmDetail


interface MainView : PresentationView {
    fun showFilms(films: List<FilmDetail>)
}