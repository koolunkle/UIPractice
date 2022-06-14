package com.neppplus.ui_practice_20211101.ui.activity.room

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.neppplus.ui_practice_20211101.db.AppRepository
import com.neppplus.ui_practice_20211101.db.entity.AppEntity
import com.neppplus.ui_practice_20211101.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val repository: AppRepository) : BaseViewModel() {
  fun getAllRecords(): Flow<PagingData<AppEntity>> {
    return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
      pagingSourceFactory = { repository.getAllRecords() }).flow.cachedIn(viewModelScope)
  }

  fun insertAppRecords() {
    for (i in 1..500) {
      repository.insertRecord(AppEntity(0, "Dummy $i"))
    }
  }
}