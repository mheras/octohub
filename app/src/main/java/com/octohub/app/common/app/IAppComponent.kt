package com.octohub.app.common.app

import com.octohub.app.common.di.AppScope
import com.octohub.app.common.di.IComponent
import dagger.Component
import retrofit2.Retrofit

@AppScope
@Component(modules = arrayOf(AppModule::class))
interface IAppComponent : IComponent<App> {

    fun app(): App

    fun retrofit(): Retrofit

}