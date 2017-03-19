package com.octohub.app.common.di

import com.octohub.app.common.mvp.BaseController

interface IControllerComponent<ControllerType : BaseController<*, *, ControllerType>> : IComponent<ControllerType>