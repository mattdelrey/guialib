package com.jdelosre.guialib.guides.usecase

import com.jdelosre.guialib.network.entities.Guide
import com.jdelosre.guialib.network.repos.GuideRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetGuidesUseCase @Inject constructor(private val guideRepo: GuideRepo) {
    suspend fun invoke(): Flow<List<Guide>> = withContext(Dispatchers.IO) {
        guideRepo.upcomingGuides
    }
}