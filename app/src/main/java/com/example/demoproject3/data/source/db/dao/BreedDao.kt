package com.example.demoproject3.data.source.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.demoproject3.data.source.db.entity.Breed

@Dao
interface BreedDao {

    @Query("SELECT * FROM tbl_create_breeds")
    suspend fun getBreeds(): List<Breed>?
}