package com.octohub.app.common.mvp

interface IPresenter<ViewStateType : IViewState, ViewType : IView<ViewStateType>> {

    val view: ViewType

    fun initialViewState(): ViewStateType

}