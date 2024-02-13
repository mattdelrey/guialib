package com.jdelosre.guialib.network.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiManager @Inject constructor(private val guidesService: GuidesApiService) {
    suspend fun getGuides() = withContext(Dispatchers.IO) {
        guidesService.getUpcomingGuides()
    }
}