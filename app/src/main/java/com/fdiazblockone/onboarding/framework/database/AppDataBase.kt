package com.fdiazblockone.onboarding.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [InfoEntity::class, BlockEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract val blockDAO: BlockDAO
}
