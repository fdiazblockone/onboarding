package com.fdiazblockone.onboarding.framework.database

import com.fdiazblockone.onboarding.data.sources.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(private val db: AppDataBase) : LocalDataSource {
    override suspend fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun saveInfo(any: Any): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getInfo(): String {
        TODO("Not yet implemented")
    }

    override suspend fun insertBlock(block: BlockEntity) = withContext(Dispatchers.IO) {
        db.blockDAO.insertBlock(block)
    }

    override suspend fun getBlocks(): List<BlockEntity> = withContext(Dispatchers.IO) {
        db.blockDAO.getBlocks()
    }

    override suspend fun getBlockById(blockId: String) = withContext(Dispatchers.IO) {
        db.blockDAO.getBlockById(blockId)
    }
}