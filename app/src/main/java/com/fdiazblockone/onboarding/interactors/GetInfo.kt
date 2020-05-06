package com.fdiazblockone.onboarding.interactors

import com.fdiazblockone.onboarding.data.repositories.ListRepository

class GetInfo(private val infoRepository: ListRepository) {

    suspend fun invoke() = infoRepository.getInfo()
}
