package com.fdiazblockone.onboarding.framework.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlockDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBlock(block: BlockEntity)

    @Query("SELECT * FROM block_table")
    fun getBlocks(): List<BlockEntity>

    @Query("SELECT * FROM block_table WHERE id = :blockId")
    fun getBlockById(blockId: String): BlockEntity

}