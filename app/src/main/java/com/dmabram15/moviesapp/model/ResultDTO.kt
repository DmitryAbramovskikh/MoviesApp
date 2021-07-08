package com.dmabram15.moviesapp.model

import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("results")
    val moviesResult: List<Movie>
)