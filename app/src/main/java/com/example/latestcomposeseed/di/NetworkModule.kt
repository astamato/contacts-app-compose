package com.example.latestcomposeseed.di

import android.content.Context
import com.example.latestcomposeseed.data.ContactsRetrofitAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    internal fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val cacheDir = File(context.cacheDir, HTTP_CACHE_DIR_NAME)
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())

        return OkHttpClient.Builder().connectTimeout(
            CONNECTION_TIMEOUT_SECONDS.toLong(),
            TimeUnit.SECONDS
        )
            .readTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .cache(cache).build()
    }

    @Provides
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    internal fun provideService(retrofit: Retrofit): ContactsRetrofitAPI {
        return retrofit.create(ContactsRetrofitAPI::class.java)
    }

    companion object {
        const val CONNECTION_TIMEOUT_SECONDS = 30
        const val HTTP_CACHE_DIR_NAME = "okhttp_cache"
        const val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB

        const val DATE_FORMAT = "yyyy-MM-dd"
        const val BASE_URL = "https://randomuser.me/"
    }
}
