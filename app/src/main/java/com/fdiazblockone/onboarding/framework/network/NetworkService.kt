package com.fdiazblockone.onboarding.framework.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NetworkService {

    @GET("get_info")
    suspend fun getInfo(): Info

    @Headers("Content-Type: application/json")
    @POST("get_block")
    suspend fun getBlocks(@Body body: JsonObject): BlockResponse

}

data class JsonObject(
    val block_num_or_id: String
)