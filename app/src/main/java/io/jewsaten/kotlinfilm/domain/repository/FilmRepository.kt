package io.jewsaten.kotlinfilm.domain.repository

import io.jewsaten.kotlinfilm.ui.entity.FilmDetail

/**
 * Created by Administrator on 2018/3/29.
 */
class FilmRepository {
    companion object {
        fun getFilms(): List<FilmDetail> {
            val film1 = FilmDetail("test1test1test1",
                    "https://oubus-oyyx.oss-cn-hangzhou.aliyuncs.com/uploads/video/2018-03-26/1.mp4")
            val film2 = FilmDetail("test2test2test2",
                    "https://oubus-oyyx.oss-cn-hangzhou.aliyuncs.com/uploads/video/2018-03-26/2.mp4")
            return listOf(film1, film2)
        }
    }
}