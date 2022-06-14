package com.neppplus.ui_practice_20211101.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app")
data class AppEntity(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  val id: Int = 0,
  @ColumnInfo(name = "name")
  val name: String
) {
}