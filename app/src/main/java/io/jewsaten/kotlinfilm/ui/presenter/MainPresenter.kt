package io.jewsaten.kotlinfilm.ui.presenter

import com.birbit.android.jobqueue.JobManager
import io.jewsaten.kotlinfilm.App
import io.jewsaten.kotlinfilm.domain.interactor.GetFilmsInteractor
import io.jewsaten.kotlinfilm.domain.interactor.base.Bus
import io.jewsaten.kotlinfilm.domain.interactor.base.Interactor
import io.jewsaten.kotlinfilm.domain.interactor.base.InteractorPriority
import io.jewsaten.kotlinfilm.domain.interactor.base.InteractorWrapper
import io.jewsaten.kotlinfilm.domain.interactor.event.FilmsEvent
import io.jewsaten.kotlinfilm.domain.repository.FilmRepository
import io.jewsaten.kotlinfilm.ui.view.MainView

/**
 * Created by Administrator on 2018/3/29.
 */
class MainPresenter(
        override val view: MainView,
        override val bus: Bus = App.instance.provideEventBus(),
        val jobManager: JobManager = App.instance.provideJobManager()) : Presenter<MainView> {

    init {
        onResume()
    }

    override fun onResume() {
        super.onResume()
        execute(GetFilmsInteractor(FilmRepository.getFilms()))
    }

    private fun execute(interactor: Interactor, priority: InteractorPriority = InteractorPriority.LOW) {
        jobManager.addJobInBackground(InteractorWrapper(interactor, priority, bus))
    }

    fun onEvent(event: FilmsEvent) {
        view.showFilms(event.films)
    }

}