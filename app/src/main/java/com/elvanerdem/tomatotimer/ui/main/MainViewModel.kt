package com.elvanerdem.tomatotimer.ui.main

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import androidx.core.app.AlarmManagerCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elvanerdem.tomatotimer.receiver.AlarmReceiver
import com.elvanerdem.tomatotimer.ui.base.BaseViewModel
import com.elvanerdem.tomatotimer.utils.SECOND
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    private lateinit var alarmManager: AlarmManager
    private lateinit var notifyIntent: Intent
    private lateinit var notifyPendingIntent: PendingIntent

    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long>
        get() = _elapsedTime


    private lateinit var timer: CountDownTimer

    fun startTimer() {
        alarmManager = app.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        notifyIntent = Intent(app, AlarmReceiver::class.java)
        notifyPendingIntent = PendingIntent.getBroadcast(app, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val triggerTime = SystemClock.elapsedRealtime() + SECOND * 10

        AlarmManagerCompat.setExactAndAllowWhileIdle(
            alarmManager,
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            triggerTime,
            notifyPendingIntent
        )

        createTimer()

    }


    private fun createTimer() {
        viewModelScope.launch {
            val triggerTime = SystemClock.elapsedRealtime() + SECOND * 10
            timer = object : CountDownTimer(triggerTime, SECOND) {
                override fun onTick(millisUntilFinished: Long) {
                    _elapsedTime.value = triggerTime - SystemClock.elapsedRealtime()
                    if (_elapsedTime.value!! <= 0) {
                        resetTimer()
                    }
                }

                override fun onFinish() {
                    resetTimer()
                }
            }
            timer.start()
        }
    }

    private fun resetTimer() {
        timer.cancel()
        _elapsedTime.value = 0
        //_alarmOn.value = false
    }

}