package com.fdiazblockone.onboarding.interactors

import com.fdiazblockone.onboarding.data.repositories.ListRepository
import com.fdiazblockone.onboarding.framework.network.JsonObject

class GetBlocks(private val infoRepository: ListRepository) {
    suspend fun invoke(obj:JsonObject) = infoRepository.getBlocks(obj)
}

