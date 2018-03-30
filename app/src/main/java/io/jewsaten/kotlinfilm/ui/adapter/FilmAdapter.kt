package io.jewsaten.kotlinfilm.ui.adapter

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.VideoView

import io.jewsaten.kotlinfilm.R
import io.jewsaten.kotlinfilm.ui.activity.ViewAnkoComponent
import io.jewsaten.kotlinfilm.ui.custom.customVideo
import io.jewsaten.kotlinfilm.ui.entity.FilmDetail
import io.jewsaten.kotlinfilm.util.setTextAppearanceC
import org.jetbrains.anko.*

/**
 * Created by Administrator on 2018/3/30.
 */
class FilmAdapter(listener: (FilmDetail) -> Unit)
    : BaseAdapter<FilmDetail, FilmAdapter.Component>(listener) {

    override val bind: Component.(item: FilmDetail) -> Unit = { item ->
        title.text = item.title
        video.setVideoURI(Uri.parse(item.rawUrl))
        video.start()
    }

    override fun onCreateComponent(parent: RecyclerView) = Component(parent)

    fun findPositionById(url: String): Int = items.withIndex().first { it.value.rawUrl == url }.index

    class Component(override val view: RecyclerView) : ViewAnkoComponent<RecyclerView> {

        lateinit var title: TextView
        lateinit var video: VideoView

        override fun createView(ui: AnkoContext<RecyclerView>) = with(ui) {
            frameLayout {

                verticalLayout {
                    video = customVideo{
                        id = View.generateViewId()
                    }.lparams(width = matchParent,height = dimen(R.dimen.video_height))
                    title = textView {
                        padding = dip(16)
                        backgroundResource = R.color.cardview_dark_background
                        setTextAppearanceC(R.style.TextAppearance_AppCompat_Subhead_Inverse)
                        maxLines = 1
                        ellipsize = TextUtils.TruncateAt.END
                    }.lparams(width = matchParent)

                }.lparams(width = matchParent)

            }
        }
    }

}