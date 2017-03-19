package com.octohub.app.common.app

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.octohub.app.common.di.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val app: App) {

    @AppScope
    @Provides
    internal fun provideApp(): App {
        return app
    }

    @AppScope
    @Provides
    internal fun provideAppContext(): Context {
        return app.applicationContext
    }

    @AppScope
    @Provides
    internal fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.github.com/").client(httpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    @AppScope
    @Provides
    internal fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(StethoInterceptor()).build()
    }

    @AppScope
    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }
}