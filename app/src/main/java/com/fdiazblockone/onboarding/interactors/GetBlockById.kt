package com.fdiazblockone.onboarding.interactors

import com.fdiazblockone.onboarding.data.repositories.ListRepository

class GetBlockById(private val listRepository: ListRepository) {
    suspend fun invoke(id: String) = listRepository.getBlockById(id)
}
