package com.octohub.app.feature.user

import com.octohub.app.common.mvp.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(view: IHomeView) : BasePresenter<HomeViewState, IHomeView>(view) {

    override fun initialViewState(): HomeViewState = HomeViewState()

}