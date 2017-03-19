package com.octohub.app.feature.user

import com.octohub.app.common.app.IAppComponent
import com.octohub.app.common.di.ControllerScope
import com.octohub.app.common.di.IControllerComponent
import dagger.Component

@ControllerScope
@Component(dependencies = arrayOf(IAppComponent::class), modules = arrayOf(HomeModule::class))
interface IHomeComponent : IControllerComponent<HomeController>