package com.neppplus.ui_practice_20211101.ui.activity.init

import androidx.lifecycle.LiveData
import com.neppplus.ui_practice_20211101.SingleLiveEvent
import com.neppplus.ui_practice_20211101.ui.activity.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor() : BaseViewModel() {
  private val navigation = SingleLiveEvent<InitNavigation>()
  val initNavigation: LiveData<InitNavigation>
    get() = navigation

  fun moveRetrofit() {
    navigation.value = InitNavigation.MOVE_RETROFIT
  }

  fun moveRoom() {
    navigation.value = InitNavigation.MOVE_ROOM
  }
}