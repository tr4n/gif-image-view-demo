package com.example.demoproject3.data.source.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demoproject3.data.source.db.dao.BreedDao
import com.example.demoproject3.data.source.db.entity.Breed
import com.huma.room_for_asset.RoomAsset

private const val DATABASE_VERSION = 2
private const val DATABASE_NAME = "dog_breeds.db"

@Database(entities = [Breed::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao

    companion object {

        const val NAME = "AppDatabase"

        private var sInstance: AppDatabase? = null

        @JvmStatic
        fun getInstance(context: Context) = sInstance ?: getDatabase(context).also { sInstance = it }

        @JvmStatic
        private fun getDatabase(context: Context): AppDatabase =
            RoomAsset.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }
}
