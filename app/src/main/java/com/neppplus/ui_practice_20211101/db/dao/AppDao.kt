package com.neppplus.ui_practice_20211101.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neppplus.ui_practice_20211101.db.entity.AppEntity

@Dao
interface AppDao {
  @Query("SELECT * FROM app ORDER BY id ASC")
  fun getAllRecords(): PagingSource<Int, AppEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertRecord(appEntity: AppEntity)

  @Query("UPDATE app set name = :name WHERE id = :id")
  fun update(id: Int, name: String)

  @Query("DELETE FROM app WHERE id = :id")
  fun delete(id: Int)
}