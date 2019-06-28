package com.example.demoproject3.data.source.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "tbl_breeds"

private const val FIELD_ID = "id"
private const val FIELD_NAME = "name"
private const val FIELD_OTHER_NAMES = "otherNames"
private const val FIELD_ORIGIN = "origin"
private const val FIELD_DESCRIPTION = "description"
private const val FIELD_IMG_URL = "imgUrl"

@Entity(tableName = TABLE_NAME)
data class Breed(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = FIELD_ID) val id: Int,
    @ColumnInfo(name = FIELD_NAME) val name: String,
    @ColumnInfo(name = FIELD_OTHER_NAMES) val otherNames: String,
    @ColumnInfo(name = FIELD_ORIGIN) val origin: String,
    @ColumnInfo(name = FIELD_DESCRIPTION) val description: String,
    @ColumnInfo(name = FIELD_IMG_URL) val imgUrl: String
)
