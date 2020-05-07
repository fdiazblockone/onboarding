package com.fdiazblockone.onboarding.framework.network

import com.fdiazblockone.onboarding.data.sources.RemoteDataSource

class NetworkDataSource(private val network: Network) : RemoteDataSource {
    override suspend fun getInfo(): Info {
        return network.service.getInfo()
    }

    override suspend fun getBlocks(obj:JsonObject): BlockResponse {
        return network.service.getBlocks(obj)
    }
}

