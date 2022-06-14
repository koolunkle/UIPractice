package com.neppplus.ui_practice_20211101.db

import androidx.paging.PagingSource
import com.neppplus.ui_practice_20211101.db.dao.AppDao
import com.neppplus.ui_practice_20211101.db.entity.AppEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppRepository @Inject constructor(private val appDao: AppDao) {
  fun getAllRecords(): PagingSource<Int, AppEntity> {
    return appDao.getAllRecords()
  }

  fun insertRecord(appEntity: AppEntity) {
    CoroutineScope(Dispatchers.IO).launch {
      appDao.insertRecord(appEntity)
    }
  }
}