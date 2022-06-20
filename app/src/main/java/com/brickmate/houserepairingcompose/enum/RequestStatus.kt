package com.brickmate.houserepairingcompose.enum

import android.content.Context
import com.brickmate.houserepairingcompose.R


/**
 * Created by BM Dong on 6/29/2021.
 * Email : hoaidongit5@brickmate.vn or hoaidongit5@gmail.com.
 * Discord : BM Dong#9521.
 */

const val STATUS_PENDING = 0 // customer create offer
const val STATUS_ASSIGNING = 1 // admin assigning for engineer, wait engineer accept
const val STATUS_ASSIGNED = 2 // engineer accepted
const val STATUS_WAIT_REASSIGN = 3 // engineer don't accept, wait admin reassign
const val STATUS_REASSIGNING = 4 // admin reassign for another engineer
const val STATUS_REASSIGNED = 5 // another engineer accept
const val STATUS_VISIT = 6 // engineer report visit
const val STATUS_ESTIMATE = 7 // engineer estimate
const val STATUS_PAYMENT_FINISH = 8 // customer payment finish
const val STATUS_WORKING = 9 // engineer start upload before image and working
const val STATUS_ESTIMATE_EXTRA = 10 // if need extra, engineer add extra estimate
const val STATUS_PAYMENT_EXTRA_FINISH = 11 // customer pay extra finish
const val STATUS_WORK_COMPLETE = 12 // engineer report complete, upload after image
const val STATUS_WORK_COMPLETE_NEED_EXTRA =
    13 // engineer report complete, upload after image but need extra, admin will click revisit for create new offer
const val STATUS_CUSTOMER_CHECKED = 14 //customer submit report offer
const val STATUS_CANCEL = 15 // admin cancel
const val STATUS_CUSTOMER_CANCEL = 16 // customer cancel
const val STATUS_ENGINEER_CANCEL = 17 // engineer cancel
const val STATUS_CUSTOMER_CHANGE_DATETIME = 18 // customer request change datetime

fun findStringForView(status: Int, context: Context): String {
    return when (status) {
        STATUS_PENDING -> {
            context.getString(R.string.common_type_request_pending)
        }
        STATUS_CANCEL -> {
            context.getString(R.string.common_type_request_cancel)
        }
        STATUS_ASSIGNING -> {
            context.getString(R.string.common_type_request_assigning)
        }
        STATUS_ASSIGNED -> {
            context.getString(R.string.common_type_request_assigned)
        }
        STATUS_WAIT_REASSIGN -> {
            context.getString(R.string.common_type_request_wait_assigning)
        }
        STATUS_REASSIGNING -> {
            context.getString(R.string.common_type_request_re_assigning)
        }
        STATUS_REASSIGNED -> {
            context.getString(R.string.common_type_request_re_assigned)
        }
        STATUS_VISIT -> {
            context.getString(R.string.common_type_request_visit)
        }
        STATUS_ESTIMATE -> {
            context.getString(R.string.common_type_request_estimate)
        }
        STATUS_PAYMENT_FINISH -> {
            context.getString(R.string.common_type_request_payment)
        }
        STATUS_WORKING -> {
            context.getString(R.string.common_type_request_work)
        }
        STATUS_WORK_COMPLETE -> {
            context.getString(R.string.common_type_request_work_complete)
        }
        STATUS_ESTIMATE_EXTRA -> {
            context.getString(R.string.common_type_request_estimate_extra)
        }
        STATUS_PAYMENT_EXTRA_FINISH -> {
            context.getString(R.string.common_type_request_payment_extra)
        }
        STATUS_CUSTOMER_CANCEL -> {
            context.getString(R.string.common_type_request_user_cancel)
        }
        STATUS_ENGINEER_CANCEL -> {
            context.getString(R.string.common_type_request_engineer_cancel)
        }
        STATUS_CUSTOMER_CHECKED -> {
            context.getString(R.string.common_type_request_checked)
        }
        STATUS_WORK_COMPLETE_NEED_EXTRA -> {
            context.getString(R.string.common_type_request_work_complete_extra)
        }
        STATUS_CUSTOMER_CHANGE_DATETIME -> {
            context.getString(R.string.common_type_request_user_change_date)
        }
        else -> {
            context.getString(R.string.common_type_request_unknown)
        }
    }
}

fun findColorForStatus(status: Int): Int {
    return when (status) {
        STATUS_PENDING -> {
            R.color.colorStatusPending
        }
        STATUS_CANCEL, STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL -> {
            R.color.colorStatusCancel
        }
        STATUS_ASSIGNING -> {
            R.color.colorStatusWarning
        }
        STATUS_ASSIGNED -> {
            R.color.colorStatusAssigned
        }
        STATUS_WAIT_REASSIGN -> {
            R.color.colorStatusWarning
        }
        STATUS_REASSIGNING -> {
            R.color.colorStatusWarning
        }
        STATUS_REASSIGNED -> {
            R.color.colorStatusAssigned
        }
        STATUS_VISIT -> {
            R.color.colorStatusVisit
        }
        STATUS_ESTIMATE -> {
            R.color.colorStatusEstimate
        }
        STATUS_PAYMENT_FINISH -> {
            R.color.colorStatusPayment
        }
        STATUS_WORKING -> {
            R.color.colorStatusWorking
        }
        STATUS_WORK_COMPLETE -> {
            R.color.colorStatusWorkComplete
        }
        STATUS_WORK_COMPLETE_NEED_EXTRA -> {
            R.color.colorStatusWorkCompleteExtra
        }
        STATUS_CUSTOMER_CHANGE_DATETIME -> {
            R.color.colorStatusUpdateDatetime
        }
        STATUS_CUSTOMER_CHECKED -> {
            R.color.colorStatusSuccess
        }
        else -> {
            R.color.button_google
        }
    }
}