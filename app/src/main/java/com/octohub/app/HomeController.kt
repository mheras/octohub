package com.octohub.app

import android.os.Bundle

class HomeController private constructor(bundle: Bundle?) : BaseController(bundle) {

    constructor() : this(null)

    override fun getLayoutResId() = R.layout.controller_home

}