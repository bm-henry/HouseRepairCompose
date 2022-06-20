package com.brickmate.houserepairingcompose.util

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.enum.*
import com.brickmate.houserepairingcompose.util.Constant.ROLE_EMPLOYEE
import com.brickmate.houserepairingcompose.util.Constant.ROLE_MANAGER
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateOfMonth
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateOfWeek
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateWithPartern
import com.brickmate.houserepairingcompose.util.TimeUtil.getDayAnTimeView
import com.brickmate.houserepairingcompose.util.TimeUtil.getTimeFromTimestamp24hFromString


@BindingAdapter("loadStatusOffer")
fun loadStatusOffer(view: TextView, status: Int) {
    when (status) {

        STATUS_ASSIGNING -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_assigning)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }

        STATUS_ASSIGNED, STATUS_REASSIGNED -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_assigned)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_REASSIGNING -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_assigning)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_ESTIMATE -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_estimate)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_ESTIMATE_EXTRA -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_estimate_extra)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_PAYMENT_FINISH -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_payment)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_PAYMENT_EXTRA_FINISH -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.status_payment_extra)
            view.setBackgroundResource(R.drawable.border_offer_accept)
        }
        STATUS_VISIT -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.button_yellow))
            view.text = view.resources.getText(R.string.status_visit)
            view.setBackgroundResource(R.drawable.border_offer_visiting)
        }
        STATUS_WORKING -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.blue_button))
            view.text = view.resources.getText(R.string.status_working)
            view.setBackgroundResource(R.drawable.border_offer_working)
        }
        STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL, STATUS_CANCEL -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.text_red))
            view.text = view.resources.getText(R.string.status_cancel)
            view.setBackgroundResource(R.drawable.border_offer_cancel)
        }
        STATUS_WORK_COMPLETE, STATUS_WORK_COMPLETE_NEED_EXTRA -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.green_100_percent))
            view.text = view.resources.getText(R.string.status_complete)
            view.setBackgroundResource(R.drawable.border_offer_complete)

        }
        STATUS_CUSTOMER_CHANGE_DATETIME -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            view.text = view.resources.getText(R.string.common_type_request_user_change_date)
            view.setBackgroundResource(R.drawable.border_offer_accept)

        }


    }

}

@BindingAdapter("offerDesireDate")
fun offerDesireDate(view: TextView, date: String?) {
    date?.let {
        val data = "${getDateOfMonth(date)} ${getDateOfWeek(date)}"
        view.text = data
    }
}

@BindingAdapter("offerDesireDateAndYear")
fun offerDesireDateAndYear(view: TextView, date: String?) {
    date?.let {
        view.text = getDateWithPartern(date)
    }
}

@BindingAdapter("offerTime")
fun offerTime(view: TextView, time: String?) {
    time?.let {
        view.text = getTimeFromTimestamp24hFromString(time)
    }

}


@BindingAdapter("offerCreatedTime")
fun offerCreatedTime(view: TextView, time: String?) {
    time?.let {
        view.text = getDayAnTimeView(time)
    }

}

@BindingAdapter("setTextSpecial")
fun setTextSpecial(view: TextView, data: String?) {
    data?.let {
        val text = "$data >"
        view.text = text
    }

}

@BindingAdapter("setRoleForRepair")
fun TextView.setRoleForRepair(data: MyInfo?) {

    when (data?.groupId) {
        ROLE_EMPLOYEE -> {
            this.background =
                ContextCompat.getDrawable(this.context, R.drawable.border_rectangle_white_80)
            this.text = this.context.getString(R.string.info_employee)
        }
        ROLE_MANAGER -> {
            this.background =
                ContextCompat.getDrawable(this.context, R.drawable.border_rectangle_yellow)
            this.text = this.context.getString(R.string.info_manager)
        }
        else -> {
            this.background =
                ContextCompat.getDrawable(this.context, R.drawable.border_rectangle_yellow)
            this.text = this.context.getString(R.string.info_manager)
        }
    }

}