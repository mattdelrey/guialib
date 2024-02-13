package com.jdelosre.guialib.network.repos


import com.jdelosre.guialib.guides.viewmodel.GuidesUIState
import com.jdelosre.guialib.network.api.ApiManager
import com.jdelosre.guialib.network.entities.Guide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GuideRepo @Inject constructor(
    private val apiManager: ApiManager,
) {
    private val _upcomingGuides = MutableStateFlow(listOf<Guide>())
    val upcomingGuides: StateFlow<List<Guide>> = _upcomingGuides.asStateFlow()

    suspend fun loadGuides(): Boolean {
        val response = apiManager.getGuides()

        if(response.isSuccessful){
            // TODO This is making assumption that guides is always returning
            // a list whether it's empty or not. If we can't assume that, we'd
            // have to write code to handle null case
            response.body()?.guides?.let {
                _upcomingGuides.value = it
            }
        }

        // TODO simplified way to indicate error. Ideally, we could be more explicit if this is due to network connection, etc
        return response.isSuccessful
    }
}