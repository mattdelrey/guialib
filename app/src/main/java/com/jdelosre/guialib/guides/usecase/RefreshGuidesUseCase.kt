package com.jdelosre.guialib.guides.usecase

import com.jdelosre.guialib.network.repos.GuideRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RefreshGuidesUseCase @Inject constructor(private val guideRepo: GuideRepo) {
    suspend fun invoke(): Boolean = withContext(Dispatchers.IO) {
        guideRepo.loadGuides()
    }
}