package com.brickmate.houserepairingcompose.enum

enum class TimeType(val type: Int) {
    MINUTE(0),
    HOUR_MINUTE(1),
    HOUR(2),
    DAY_OF_WEEK(3),
    DAY(4),
    MONTH_STRING(5),
    MONTH_NUMBER(6),
    YEAR(7),
}