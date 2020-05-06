package com.fdiazblockone.onboarding.framework.network

import com.fdiazblockone.onboarding.framework.database.BlockEntity as DatabaseModel
import com.squareup.moshi.Json
import com.fdiazblockone.onboarding.domain.Block as DomainModel

data class BlockResponse(
    val id: String,
    val timestamp: String,
    val producer: String,
    val transactions: List<Block>,
    @Json(name = "block_num") val blockNum: Long,
    @Json(name = "ref_block_prefix") val refBlockPrefix: Long,
    @Json(name = "schedule_version") val scheduleVersion: Long,
    @Json(name = "producer_signature") val producerSignature: String
)

data class Block(
    val status: String,
    val trx: Trx,
    @Json(name = "cpu_usage_us") val cpuUsageUs: Long,
    @Json(name = "net_usage_words") val netUsageWords: Long
)

data class Trx(
    val id: String,
    val compression: String,
    val signatures: List<String?>? = null
)


fun BlockResponse.asDatabaseModel(): List<DatabaseModel> {

    return transactions.map {
        DatabaseModel(
            id = it.trx.id,
            status = it.status,
            producer = producer,
            producerSignature = producerSignature,
            cpuUsageUs = it.cpuUsageUs,
            netUsageWords = it.netUsageWords,
            compression = it.trx.compression,
            signature = it.trx.signatures?.get(0).let { signature -> signature } ?: ""
        )
    }
}
