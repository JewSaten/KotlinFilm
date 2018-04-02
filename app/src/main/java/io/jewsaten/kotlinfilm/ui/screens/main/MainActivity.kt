package io.jewsaten.kotlinfilm.ui.screens.main

import android.os.Bundle
import io.jewsaten.kotlinfilm.ui.activity.BaseActivity
import io.jewsaten.kotlinfilm.ui.adapter.FilmAdapter
import io.jewsaten.kotlinfilm.ui.entity.FilmDetail
import io.jewsaten.kotlinfilm.ui.presenter.MainPresenter
import io.jewsaten.kotlinfilm.ui.view.MainView

class MainActivity : BaseActivity<MainLayout>(), MainView {
    override val ui = MainLayout()
    private lateinit var presenter: MainPresenter
    private val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        ui.recycler.adapter = adapter
    }

    override fun showFilms(films: List<FilmDetail>) {
        adapter.items = films
    }

}
