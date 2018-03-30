package io.jewsaten.kotlinfilm.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

abstract class BaseActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>> : AppCompatActivity() {

    companion object {
        val COVER_TRANSITION_NAME = "activity_cover_transition"
    }

    abstract val ui: UI

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (ui as ActivityAnkoComponent<AppCompatActivity>).setContentView(this)
        setSupportActionBar(ui.toolbar)
    }

}