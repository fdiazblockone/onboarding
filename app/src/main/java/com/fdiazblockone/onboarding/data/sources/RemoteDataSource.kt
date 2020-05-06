package com.fdiazblockone.onboarding.data.sources

import com.fdiazblockone.onboarding.framework.network.BlockResponse
import com.fdiazblockone.onboarding.framework.network.Info
import com.fdiazblockone.onboarding.framework.network.JsonObject

interface RemoteDataSource {

    suspend fun getInfo(): Info

    suspend fun getBlocks(obj: JsonObject): BlockResponse
}