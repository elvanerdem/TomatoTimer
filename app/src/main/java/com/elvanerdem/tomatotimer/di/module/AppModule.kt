package com.elvanerdem.tomatotimer.di.module

import android.content.Context
import com.elvanerdem.tomatotimer.TomatoTimerApp
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindContext(application: TomatoTimerApp): Context
}