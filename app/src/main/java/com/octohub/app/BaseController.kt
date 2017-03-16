package com.octohub.app

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller

abstract class BaseController protected constructor(bundle: Bundle?) : Controller(bundle) {

    private lateinit var unbinder: Unbinder

    protected constructor() : this(null)

    override final fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(getLayoutResId(), container, false)
        unbinder = ButterKnife.bind(this, view)
        onViewBound(view)
        return view
    }

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    protected open fun onViewBound(view: View) = Unit

    override fun onDestroyView(view: View) {
        unbinder.unbind()
        super.onDestroyView(view)
    }
}