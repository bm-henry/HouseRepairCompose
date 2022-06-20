package com.brickmate.houserepairingcompose.util

import android.annotation.SuppressLint
import com.brickmate.houserepairingcompose.enum.TimeType
import com.brickmate.houserepairingcompose.util.Constant.LOCALE_APP

import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

    fun getDateTimeFromTimestamp(any: Any): String {
        val pattern = "MM/dd hh:mm"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getFullDateTimeFromTimestamp(any: Any): String {
        val pattern = "yyyy/MM/dd HH:mm"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getDateFromTimestamp(any: Any): String {
        val pattern = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getYearMonthFromTimestamp(any: Any): String {
        val pattern = "yyyy-MM"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getTime12hFromTimestamp(any: Any): String {
        val pattern = "hh:mm aa"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getTime12hRevertFromTimestamp(any: Any): String {
        val pattern = "aa hh:mm"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getTime24hFromTimestamp(any: Any): String {
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    fun getTime24hFromTimes(any: Any): String {
        val pattern = "HH:mm"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any) else any as Date
        return sdf.format(date)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateFromIsoString(isoString: String): Date {
        return try {
            val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000000'Z'", Locale.KOREA)
            isoFormat.timeZone = TimeZone.getTimeZone("UTC")
            isoFormat.parse(isoString) as Date
        } catch (e: Exception) {
            Date()
        }
    }

    fun getDateFromCreateAt(string: String?): String? {
        return try {
            string?.let {
                val date = getDateFromIsoString(string)
                getFullDateTimeFromTimestamp(date)
            }

        } catch (ex: Exception) {
            null
        }
    }

    fun getDateOfWeek(dateString: String): String {
        val pattern = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = sdf.parse(dateString) as Date
        val dateOfWeekFormat = SimpleDateFormat("EEEE", Locale.KOREA)
        return dateOfWeekFormat.format(date)
    }

/*    fun getDateOfWeekKorea(date: String): String {

    }*/

    fun getDateOfMonth(dateString: String): String {
        val pattern = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date = sdf.parse(dateString) as Date
        val dateOfWeekFormat = SimpleDateFormat("MM.dd", Locale.KOREA)
        return dateOfWeekFormat.format(date)
    }

    fun getDayAnTimeView(dateString: String): String {
        val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val date = sdf.parse(dateString) as Date
        val dateOfWeekFormat = SimpleDateFormat("yy.MM.dd HH:mm", Locale.KOREA)
        return dateOfWeekFormat.format(date)
    }

    fun getDateWithPartern(dateString: String): String {
        val pattern = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date = sdf.parse(dateString) as Date
        val dateOfWeekFormat = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA)
        return dateOfWeekFormat.format(date)
    }

    fun getDateOfMonthDetail(dateString: String): String {
        val pattern = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date = sdf.parse(dateString) as Date
        val dateOfWeekFormat = SimpleDateFormat("MM.dd", Locale.KOREA)
        return dateOfWeekFormat.format(date) + "(${getDateOfWeek(dateString)})"
    }

    fun getTimeFromTimestamp24h(any: Any): String {
        val pattern = "mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val date: Date = if (any is Long) Date(any)
        else any as Date
        return sdf.format(date)
    }

    fun getTimeFromTimestamp24hFromString(timeString: String): String {
        val pattern = "hh:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.KOREA)
        val time = sdf.parse(timeString) as Date
        val returnTimeFm = SimpleDateFormat("HH:mm", Locale.KOREA)
        returnTimeFm.format(time)
        return returnTimeFm.format(time)
    }

    fun getTimeSingleFromTimestamp(input: Long, type: TimeType): String? {
        try {
            val cal = Calendar.getInstance()
            cal.timeInMillis = input

            val string: String = when (type) {
                TimeType.MINUTE -> "mm"
                TimeType.HOUR_MINUTE -> "HH:mm"
                TimeType.HOUR -> "HH"
                TimeType.DAY_OF_WEEK -> "EEEE"
                TimeType.DAY -> "dd"
                TimeType.MONTH_NUMBER -> "MM"
                TimeType.MONTH_STRING -> "MMM"
                TimeType.YEAR -> "yyyy"
            }

            return string.let {
                val sdf = SimpleDateFormat(it, LOCALE_APP)
                sdf.format(input)
            }

        } catch (ex: Exception) {
            return null
        }

    }

    fun parseStringToDateTime24h(string: String): Date? {
        return try {
            val pattern = "yyyy-MM-dd HH:mm"
            val date1 = SimpleDateFormat(pattern, Locale.KOREA).parse(string)
            date1
        } catch (e: Exception) {
            null
        }
    }

    fun parseStringToDateTime(string: String): Date? {
        return try {
            val pattern = "yyyy-MM-dd hh:mm aa"
            val date1 = SimpleDateFormat(pattern, Locale.KOREA).parse(string)
            date1
        } catch (e: Exception) {
            null
        }
    }

    fun parseStandardStringToDate(string: String): Date? {
        return try {
            val pattern = "yyyy-MM-dd"
            val date1 = SimpleDateFormat(pattern, Locale.KOREA).parse(string)
            date1
        } catch (e: Exception) {
            Date()
        }
    }

    fun checkIsInWorkingTime(date: Date, serviceStartTime: String, serviceEndTime: String): Boolean {
        try {
            val startWorking = Calendar.getInstance()
            startWorking.apply {
                time = date
                set(Calendar.HOUR_OF_DAY, getHourFromString(serviceStartTime))
                set(Calendar.MINUTE, getMinuteFromString(serviceStartTime))
                set(Calendar.SECOND, 0)
            }

            val endWorking = Calendar.getInstance()
            endWorking.apply {
                time = date
                set(Calendar.HOUR_OF_DAY, getHourFromString(serviceEndTime))
                set(Calendar.MINUTE, getMinuteFromString(serviceEndTime))
                set(Calendar.SECOND, 0)
            }
            val currentDate = Calendar.getInstance()
            currentDate.time = date
            return currentDate.after(startWorking) && currentDate.before(endWorking)
        } catch (e: Exception) {

            return false
        }
    }

    /**
     * Get hour from string input
     */
    private fun getHourFromString(target: String): Int {
        val index = target.indexOf(":")
        return if (index != 0) {
            try {
                target.substring(0 , index).toInt()
            } catch (e: java.lang.Exception) {
                0
            }
        } else {
            0
        }
    }

    /**
     * Get minute from string input
     */
    private fun getMinuteFromString(target: String): Int {
        val index = target.indexOf(":")
        return if (index != 0) {
            try {
                target.substring(index , target.length).toInt()
            } catch (e: java.lang.Exception) {

                0
            }
        } else {
            0
        }
    }

    fun compareHour(hour: Int, timestamp: Long) {

    }
}