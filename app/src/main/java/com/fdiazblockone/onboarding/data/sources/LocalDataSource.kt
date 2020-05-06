package com.fdiazblockone.onboarding.data.sources

import com.fdiazblockone.onboarding.framework.database.BlockEntity

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveInfo(any: Any): Boolean
    suspend fun getInfo(): String
    suspend fun insertBlock(block: BlockEntity)
    suspend fun getBlocks(): List<BlockEntity>
    suspend fun getBlockById(id: String): BlockEntity
}