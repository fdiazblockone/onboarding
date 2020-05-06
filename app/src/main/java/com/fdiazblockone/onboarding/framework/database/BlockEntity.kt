package com.fdiazblockone.onboarding.framework.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fdiazblockone.onboarding.domain.Block as DomainModel

@Entity(tableName = "block_table")
class BlockEntity(
    @PrimaryKey
    val id: String,
    val status: String,
    val producer: String,
    val producerSignature: String,
    val cpuUsageUs: Long,
    val netUsageWords: Long,
    val compression: String,
    val signature: String
)

fun BlockEntity.asDomainModel(): DomainModel {
    return DomainModel(
        id = id,
        status = status,
        producer = producer,
        producerSignature = producerSignature,
        cpuUsageUs = cpuUsageUs,
        netUsageWords = netUsageWords,
        compression = compression,
        signature = signature
    )

}