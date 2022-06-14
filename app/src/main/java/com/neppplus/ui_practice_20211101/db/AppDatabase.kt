package com.neppplus.ui_practice_20211101.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neppplus.ui_practice_20211101.db.dao.AppDao
import com.neppplus.ui_practice_20211101.db.entity.AppEntity

@Database(entities = [AppEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

  abstract fun getAppDao(): AppDao

  companion object {
    private var dbInstance: AppDatabase? = null

    @Synchronized
    fun getDbInstance(context: Context): AppDatabase {
      if (dbInstance == null) {
        dbInstance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app.db").build()
      }
      return dbInstance!!
    }
  }

}