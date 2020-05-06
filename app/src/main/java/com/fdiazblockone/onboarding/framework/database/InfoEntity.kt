package com.fdiazblockone.onboarding.framework.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class InfoEntity(

    @PrimaryKey
    val id: Int,
    @Json(name = "server_version") val serverVersion: String,
    @Json(name = "chain_id") val chainId: String,
    @Json(name = "head_block_num") val headBlockNum: Long,
    @Json(name = "last_irreversible_block_num") val lastIrreversibleBlockNum: Long,
    @Json(name = "last_irreversible_block_id") val lastIrreversibleBlockId: String,
    @Json(name = "head_block_id") val headBlockId: String,
    @Json(name = "head_block_time") val headBlockTime: String,
    @Json(name = "head_block_producer") val headBlockProducer: String,
    @Json(name = "virtual_block_cpu_limit") val virtualBlockCpuLimit: Long,
    @Json(name = "virtual_block_net_limit") val virtualBlockNetLimit: Long,
    @Json(name = "block_cpu_limit") val blockCpuLimit: Long,
    @Json(name = "block_net_limit") val blockNetLimit: Long,
    @Json(name = "server_version_string") val serverVersionString: String,
    @Json(name = "fork_db_head_block_num") val forkDbHeadBlockNum: Long,
    @Json(name = "fork_db_head_block_id") val forkDbHeadBlockId: String,
    @Json(name = "server_full_version_string") val serverFullVersionString: String
)