package com.jdelosre.guialib.network.api

import com.jdelosre.guialib.network.entities.UpcomingGuidesResult
import retrofit2.Response
import retrofit2.http.GET

interface GuidesApiService {
    @GET("v2/upcomingGuides/")
    suspend fun getUpcomingGuides(): Response<UpcomingGuidesResult>
}