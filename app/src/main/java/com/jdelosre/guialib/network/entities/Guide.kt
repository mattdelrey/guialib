package com.jdelosre.guialib.network.entities

import com.google.gson.annotations.SerializedName

data class Guide(
    val startDate: String?=null, // TODO suggestion to make startDate a long timestsamp
    val endDate: String?=null, // TODO suggestion to make startDate a long timestsamp
    val name:String?=null,
    val url: String?=null,
    val venue: Location?=null,
    @SerializedName("icon") // TODO suggestion here would be to rename "iconUrl" in the API so it's more explicit
    val iconUrl: String?=null,
) {
    // TODO One suggestion I would have here is that each guide should return an id so there is no collision
    // Even though the names are unique, there's no guarantee of that. So an id would be a strong guarantee of uniqueness
    fun getId() = name
}