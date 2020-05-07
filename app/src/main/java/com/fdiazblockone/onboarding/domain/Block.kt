package com.fdiazblockone.onboarding.domain

data class Block(
    val id: String,
    val status: String,
    val producer: String,
    val producerSignature: String,
    val cpuUsageUs: Long,
    val netUsageWords: Long,
    val compression: String,
    val signature: String
)