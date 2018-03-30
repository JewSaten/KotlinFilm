package io.jewsaten.kotlinfilm.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ViewManager
import android.widget.VideoView
import org.jetbrains.anko.custom.ankoView

/**
 * Created by Administrator on 2018/3/30.
 */
class CustomVideoView : VideoView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = getDefaultSize(0,widthMeasureSpec)
        val height = getDefaultSize(0,heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
}

fun ViewManager.customVideo(theme: Int = 0) = customVideo(theme) {}
inline fun ViewManager.customVideo(theme: Int = 0, init: CustomVideoView.() -> Unit) = ankoView(::CustomVideoView, theme, init)
