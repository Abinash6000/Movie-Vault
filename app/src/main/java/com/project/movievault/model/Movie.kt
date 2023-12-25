package com.project.movievault.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
data class ShowResponse(
    val show: ShowDetails
)

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class ShowDetails(
    val name: String?,
    val genres: List<String>?,
    val premiered: String?,
    val officialSite: String?,
    val rating: Rating,
    val image: Image?,
    val summary: String?,
) : Parcelable

@Parcelize
data class Rating(
    val average: Double?
) : Parcelable

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Image(
    val medium: String
) : Parcelable