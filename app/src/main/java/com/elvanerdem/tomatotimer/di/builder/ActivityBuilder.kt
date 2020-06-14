package com.elvanerdem.tomatotimer.di.builder

import com.elvanerdem.tomatotimer.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}