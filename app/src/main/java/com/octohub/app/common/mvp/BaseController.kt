package com.octohub.app.common.mvp

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller
import com.octohub.app.common.di.IControllerComponent
import javax.inject.Inject

abstract class BaseController<ViewStateType : IViewState, ViewType : IView<ViewStateType>, ControllerType : BaseController<ViewStateType, ViewType, ControllerType>>(bundle: Bundle?) : Controller(bundle), IView<ViewStateType> {

    private lateinit var unbinder: Unbinder

    protected abstract val component: IControllerComponent<ControllerType>

    @set:Inject
    var presenter: IPresenter<ViewStateType, ViewType>? = null

    /*
    private var _currentViewState: ViewStateType? = null
    override final var currentViewState: ViewStateType
        get() = _currentViewState!!
        set(value) {
            _currentViewState = value
        }
    */

    protected constructor() : this(null)

    override final fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        @Suppress("UNCHECKED_CAST")
        component.inject(this as ControllerType)
        val view = inflater.inflate(layoutResId(), container, false)
        unbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    @LayoutRes
    protected abstract fun layoutResId(): Int

    @CallSuper
    protected open fun onViewBound(view: View) = Unit

    //protected abstract fun onChangeViewState(oldViewState: ViewStateType?, newViewState: ViewStateType)

    @CallSuper
    override fun onDestroyView(view: View) {
        unbinder.unbind()
        presenter = null
        super.onDestroyView(view)
    }
}