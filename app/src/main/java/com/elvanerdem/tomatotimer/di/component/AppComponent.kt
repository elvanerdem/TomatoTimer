package com.elvanerdem.tomatotimer.di.component

import com.elvanerdem.tomatotimer.TomatoTimerApp
import com.elvanerdem.tomatotimer.di.builder.ActivityBuilder
import com.elvanerdem.tomatotimer.di.module.AppModule
import com.elvanerdem.tomatotimer.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ AndroidInjectionModule::class, ActivityBuilder::class, ViewModelModule::class , AppModule::class ])
interface AppComponent: AndroidInjector<TomatoTimerApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TomatoTimerApp): Builder

        fun build(): AppComponent
    }

    override fun inject(application: TomatoTimerApp)

}