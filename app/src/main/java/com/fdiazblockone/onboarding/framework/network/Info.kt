package com.fdiazblockone.onboarding.framework.network

data class Info(
    val server_version: String,
    val chain_id: String,
    val head_block_num: Long,
    val last_irreversible_block_num: Long,
    val last_irreversible_block_id: String,
    val head_block_id: String,
    val head_block_time: String,
    val head_block_producer: String,
    val virtual_block_cpu_limit: Long,
    val virtual_block_net_limit: Long,
    val block_cpu_limit: Long,
    val block_net_limit: Long,
    val server_version_string: String,
    val fork_db_head_block_num: Long,
    val fork_db_head_block_id: String,
    val server_full_version_string: String
)