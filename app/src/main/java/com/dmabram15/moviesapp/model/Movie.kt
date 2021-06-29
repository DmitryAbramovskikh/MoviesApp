package com.dmabram15.moviesapp.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id : Int,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val dateProduction: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("vote_average")
    val rating : String
)