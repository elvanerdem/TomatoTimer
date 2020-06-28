package com.elvanerdem.tomatotimer.di.module

import com.elvanerdem.tomatotimer.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentBuilderModule::class])
interface ActivityBuilder {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}