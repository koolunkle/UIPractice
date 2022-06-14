package com.neppplus.ui_practice_20211101.db

import android.content.Context
import com.neppplus.ui_practice_20211101.db.dao.AppDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
  @Singleton
  @Provides
  fun getAppDatabase(context: Context): AppDatabase {
    return AppDatabase.getDbInstance(context)
  }

  @Singleton
  @Provides
  fun appDao(appDatabase: AppDatabase): AppDao {
    return appDatabase.getAppDao()
  }
}