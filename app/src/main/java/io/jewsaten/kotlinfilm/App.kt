package io.jewsaten.kotlinfilm

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.config.Configuration
import de.greenrobot.event.EventBus
import io.jewsaten.kotlinfilm.domain.interactor.base.Bus
import io.jewsaten.kotlinfilm.util.DelegatesExt

/**
 * Created by Administrator on 2018/3/29.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    private lateinit var jobManager: JobManager
    private lateinit var eventBus: Bus

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        instance = this
        eventBus = CustomEventBus()
        jobManager = CustomJobManager(this)
    }

    fun provideJobManager(): JobManager = jobManager

    fun provideEventBus(): Bus = eventBus

    private class CustomJobManager(context: Context) : JobManager(CustomJobManager.getJobManagerConfiguration(context)) {
        companion object {
            private fun getJobManagerConfiguration(context: Context): Configuration {
                return Configuration.Builder(context)
                        .minConsumerCount(1)
                        .maxConsumerCount(3)
                        .loadFactor(3)
                        .consumerKeepAlive(120)
                        .build()
            }
        }
    }

    private class CustomEventBus : EventBus(), Bus {
        val mainThread = Handler(Looper.getMainLooper())

        override fun post(event: Any) {
            mainThread.post({ super.post(event) })
        }
    }
}