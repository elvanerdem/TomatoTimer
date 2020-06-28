package com.elvanerdem.tomatotimer.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.elvanerdem.tomatotimer.BuildConfig
import com.elvanerdem.tomatotimer.TomatoTimerApp
import com.elvanerdem.tomatotimer.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber

object AppInjector {

    private val TAG = AppInjector::class.java.simpleName

    fun init(tomatoTimerApp: TomatoTimerApp) {
        DaggerAppComponent.builder().application(tomatoTimerApp).build().inject(tomatoTimerApp)

        tomatoTimerApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Timber.d(TAG + " onActivityCreated")
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                Timber.d(TAG + " onActivityStarted")
            }

            override fun onActivityResumed(activity: Activity) {
                Timber.d(TAG +" onActivityResumed")
            }

            override fun onActivityPaused(activity: Activity) {
                Timber.d(TAG +" onActivityPaused")
            }

            override fun onActivityStopped(activity: Activity) {
                Timber.d(TAG +" onActivityStopped")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
                Timber.d(TAG +" onActivitySaveInstanceState")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Timber.d(TAG +" onActivityDestroyed")
            }
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: FragmentManager,
                            f: Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }
}