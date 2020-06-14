package com.elvanerdem.tomatotimer.ui.main

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import androidx.core.app.AlarmManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.elvanerdem.tomatotimer.BR
import com.elvanerdem.tomatotimer.R
import com.elvanerdem.tomatotimer.ui.base.BaseActivity
import com.elvanerdem.tomatotimer.databinding.ActivityMainBinding
import com.elvanerdem.tomatotimer.receiver.AlarmReceiver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutRes = R.layout.activity_main
    override val bindingVariable = BR.viewModel
    override val viewModelClass = MainViewModel::class.java



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }





}
