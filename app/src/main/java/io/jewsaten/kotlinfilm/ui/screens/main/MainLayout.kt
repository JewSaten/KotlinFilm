package io.jewsaten.kotlinfilm.ui.screens.main

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import io.jewsaten.kotlinfilm.R
import io.jewsaten.kotlinfilm.ui.activity.ActivityAnkoComponent
import io.jewsaten.kotlinfilm.util.ctx
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by Administrator on 2018/3/30.
 */
class MainLayout : ActivityAnkoComponent<MainActivity> {
    lateinit var recycler: RecyclerView
    override lateinit var toolbar: Toolbar

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        coordinatorLayout {

            appBarLayout {
                toolbar = toolbar(R.style.ThemeOverlay_AppCompat_Dark_ActionBar) {
                    backgroundResource = R.color.colorPrimary
                }.lparams(width = matchParent) {
                    scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP or AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                }
            }.lparams(width = matchParent)

            recycler = recyclerView {
                layoutManager = LinearLayoutManager(ctx)
            }.lparams(matchParent, matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }
    }
}