package com.neppplus.ui_practice_20211101.di

import com.neppplus.ui_practice_20211101.network.RetrofitServiceInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  private const val BASE_URL = "https://api.github.com"

  @Singleton
  @Provides
  fun retrofitServiceInstance(retrofit: Retrofit): RetrofitServiceInstance {
    return retrofit.create(RetrofitServiceInstance::class.java)
  }

  @Singleton
  @Provides
  fun retrofitInstance(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}