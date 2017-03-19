package com.octohub.app.feature.user

import com.octohub.app.common.mvp.IView
import io.reactivex.Observable

interface IHomeView : IView<HomeViewState> {

    fun sampleIntents(): Observable<String>

}