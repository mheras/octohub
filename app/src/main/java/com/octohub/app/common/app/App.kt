package com.octohub.app.common.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary

class App : Application() {

    companion object {
        lateinit var appComponent: IAppComponent
            private set
    }

    override fun onCreate() {

        super.onCreate()

        // TODO: Move debugging tools to another flavour.
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this)
        }
        Stetho.initializeWithDefaults(this)

        appComponent = DaggerIAppComponent.builder().appModule(AppModule(this)).build()
    }

}
