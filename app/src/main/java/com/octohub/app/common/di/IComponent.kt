package com.octohub.app.common.di

interface IComponent<in InjectableType> {

    fun inject(injectable: InjectableType)

}