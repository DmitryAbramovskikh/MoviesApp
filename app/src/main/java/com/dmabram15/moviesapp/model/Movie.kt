package com.dmabram15.moviesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id : Int,
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val poster: String?,
    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,
    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val dateProduction: String,
    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val description: String,
    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val rating : String
)