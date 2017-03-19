package com.octohub.app.feature.user

import com.octohub.app.common.di.ControllerScope
import com.octohub.app.common.mvp.IPresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(val view: IHomeView) {

    @Provides
    @ControllerScope
    internal fun provideView(): IHomeView {
        return view
    }

    @Provides
    @ControllerScope
    internal fun providePresenter(presenter: HomePresenter): IPresenter<HomeViewState, IHomeView> {
        return presenter
    }
}
