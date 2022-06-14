package com.neppplus.ui_practice_20211101.ui.activity.init

import androidx.lifecycle.LiveData
import com.neppplus.ui_practice_20211101.util.SingleLiveEvent
import com.neppplus.ui_practice_20211101.BaseViewModel
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