package com.octohub.app.common.mvp

abstract class BasePresenter<ViewStateType : IViewState, ViewType : IView<ViewStateType>>(override val view: ViewType) : IPresenter<ViewStateType, ViewType> {

}