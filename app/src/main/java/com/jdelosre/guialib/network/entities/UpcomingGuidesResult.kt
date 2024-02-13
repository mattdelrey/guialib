package com.jdelosre.guialib.network.entities

import com.google.gson.annotations.SerializedName

data class UpcomingGuidesResult(
    @SerializedName("data")
    val guides: List<Guide>?,
)