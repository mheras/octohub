package com.octohub.app.feature.user

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Button
import butterknife.BindView
import com.octohub.app.R
import com.octohub.app.common.app.App
import com.octohub.app.common.di.IControllerComponent
import com.octohub.app.common.mvp.BaseController
import io.reactivex.Observable

class HomeController internal constructor(bundle: Bundle?) : BaseController<HomeViewState, IHomeView, HomeController>(bundle), IHomeView {

    override val component: IControllerComponent<HomeController> = DaggerIHomeComponent.builder().iAppComponent(App.appComponent).homeModule(HomeModule(this)).build()

    override fun sampleIntents(): Observable<String> {
        TODO("Method needs to be implemented.")
    }

    @BindView(R.id.controller_home_events_button)
    internal lateinit var eventsButton: Button

    constructor() : this(null)

    init {
        println("MATO: constructor")
    }

    override fun layoutResId() = R.layout.controller_home

    override fun onViewBound(view: View) {
        super.onViewBound(view)
        eventsButton.setOnClickListener { eventsButton.visibility = GONE }
    }

    override fun onSaveViewState(view: View, outState: Bundle) {
        super.onSaveViewState(view, outState)
        println("MATO: onSaveViewState isBeingDestroyed=$isBeingDestroyed")
    }

    override fun onRestoreViewState(view: View, savedViewState: Bundle) {
        super.onRestoreViewState(view, savedViewState)
        println("MATO: onRestoreViewState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("cosa", 69)
        println("MATO: onSaveInstanceState isBeingDestroyed=$isBeingDestroyed")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        println("MATO: onRestoreInstanceState")
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        println("MATO: onAttach")
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        println("MATO: onDetach")
    }

}