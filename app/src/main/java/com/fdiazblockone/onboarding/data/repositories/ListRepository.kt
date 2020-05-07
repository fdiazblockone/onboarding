package com.fdiazblockone.onboarding.data.repositories

import com.fdiazblockone.onboarding.data.sources.LocalDataSource
import com.fdiazblockone.onboarding.data.sources.RemoteDataSource
import com.fdiazblockone.onboarding.domain.Block as DomainBlock
import com.fdiazblockone.onboarding.framework.database.asDomainModel
import com.fdiazblockone.onboarding.framework.network.JsonObject
import com.fdiazblockone.onboarding.framework.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListRepository(private val local: LocalDataSource, private val remote: RemoteDataSource) {

    suspend fun getInfo(): String {

        /* if (local.isEmpty()) {
             val info = remote.getInfo()
             local.saveInfo(info)
         }*/

        return remote.getInfo().fork_db_head_block_id
    }

    suspend fun getBlocks(obj: JsonObject): List<DomainBlock> {
        remote.getBlocks(obj).asDatabaseModel().map {
                local.insertBlock(it)
        }
        return local.getBlocks().map { it.asDomainModel() }
    }

    suspend fun getBlockById(id: String): DomainBlock {
        return local.getBlockById(id).asDomainModel()
    }
}