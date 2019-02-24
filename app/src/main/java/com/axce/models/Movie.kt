package com.axce.models

data class Movie(
        val page: String = "",
        val total_results : String="",
        val dates: DatesBean = DatesBean(),
        val total_pages: String = "",
        val results: ArrayList<ResultsBean> = arrayListOf()
)

data class DatesBean(
        val maximum: String = "",
        val minimum: String = ""
)

data class ResultsBean(
        val vote_count: String = "",
        val id: String = "",
        val video: String = "",
        val vote_average: String = "",
        val title: String = "",
        val popularity: String = "",
        val poster_path: String = "",
        val original_language: String = "",
        val original_title: String = "",
        val backdrop_path: String = "",
        val adult: String = "",
        val overview: String = "",
        val release_date: String = "",
        val genre_ids: ArrayList<String> = arrayListOf()
)