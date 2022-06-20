package com.brickmate.houserepairingcompose.util

import android.app.Activity
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.CountDownTimer
import com.brickmate.houserepairingcompose.enum.*
import com.brickmate.houserepairingcompose.util.TimeUtil.getTimeFromTimestamp24h

object Util {

    fun getBitmapFromUri(activity: Activity, uri: Uri): Bitmap {

        val source = activity.contentResolver.openInputStream(uri)
        return BitmapFactory.decodeStream(source)

    }

    fun countDownTimer(onTick: (String) -> Unit, onFinish: () -> Unit): CountDownTimer {
        var timer = object : CountDownTimer(90000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                var timerString = getTimeFromTimestamp24h(millisUntilFinished)
                onTick.invoke(timerString)


            }

            override fun onFinish() {
                onFinish.invoke()
            }
        }
        return timer
    }

    fun getScreenWidth(): Int = Resources.getSystem().displayMetrics.widthPixels
    fun getScreenHeight(): Int = Resources.getSystem().displayMetrics.heightPixels

    fun getStatus(enum: OfferStatus): String {
        return when (enum) {
            OfferStatus.HOME -> {
                val listStatusHome = listOf(
                    STATUS_ASSIGNING,
                    STATUS_ASSIGNED,
                    STATUS_REASSIGNING,
                    STATUS_REASSIGNED,
                    STATUS_VISIT,
                    STATUS_ESTIMATE,
                    STATUS_PAYMENT_FINISH,
                    STATUS_WORKING,
                    STATUS_ESTIMATE_EXTRA,
                    STATUS_PAYMENT_EXTRA_FINISH,
                    STATUS_CANCEL,
                    STATUS_CUSTOMER_CANCEL,
                    STATUS_ENGINEER_CANCEL,
                    STATUS_CUSTOMER_CHANGE_DATETIME
                )
                listStatusHome.joinToString { it.toString() }
            }
            OfferStatus.HISTORY -> {
                val listStatusHistory = listOf(
                    STATUS_WORK_COMPLETE,
                    STATUS_WORK_COMPLETE_NEED_EXTRA,
                    STATUS_CUSTOMER_CHECKED
                )
                listStatusHistory.joinToString { it.toString() }
            }
            OfferStatus.SCHEDULE -> {
                val listStatusSchedule = listOf(
                    STATUS_ASSIGNING,
                    STATUS_ASSIGNED,
                    STATUS_WAIT_REASSIGN,
                    STATUS_REASSIGNING,
                    STATUS_REASSIGNED,
                    STATUS_VISIT,
                    STATUS_ESTIMATE,
                    STATUS_PAYMENT_FINISH,
                    STATUS_WORKING,
                    STATUS_ESTIMATE_EXTRA,
                    STATUS_PAYMENT_EXTRA_FINISH,
                    STATUS_WORK_COMPLETE,
                    STATUS_WORK_COMPLETE_NEED_EXTRA,
                    STATUS_CANCEL,
                    STATUS_CUSTOMER_CANCEL,
                    STATUS_ENGINEER_CANCEL,
                    STATUS_CUSTOMER_CHANGE_DATETIME
                )
                listStatusSchedule.joinToString { it.toString() }
            }
        }
    }
}