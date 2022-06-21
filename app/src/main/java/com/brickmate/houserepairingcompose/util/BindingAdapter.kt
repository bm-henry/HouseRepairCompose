package com.brickmate.houserepairingcompose.util

import android.content.Context
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.enum.*
import com.brickmate.houserepairingcompose.model.profile.MyInfo
import com.brickmate.houserepairingcompose.screen.theme.Blue
import com.brickmate.houserepairingcompose.screen.theme.GreenMain
import com.brickmate.houserepairingcompose.screen.theme.Red
import com.brickmate.houserepairingcompose.screen.theme.Yellow
import com.brickmate.houserepairingcompose.util.Constant.ROLE_EMPLOYEE
import com.brickmate.houserepairingcompose.util.Constant.ROLE_MANAGER
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateOfMonth
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateOfWeek
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateWithPartern
import com.brickmate.houserepairingcompose.util.TimeUtil.getDayAnTimeView
import com.brickmate.houserepairingcompose.util.TimeUtil.getTimeFromTimestamp24hFromString



fun loadStatusTextOffer(status: Int, context: Context) : CharSequence {
  return  when (status) {
        STATUS_ASSIGNING -> {
            context.resources.getText(R.string.status_assigning)
        }

        STATUS_ASSIGNED, STATUS_REASSIGNED -> {
          context.resources.getText(R.string.status_assigned)
        }
        STATUS_REASSIGNING -> {
            context.resources.getText(R.string.status_assigning)
        }
        STATUS_ESTIMATE -> {
           context.resources.getText(R.string.status_estimate)
        }
        STATUS_ESTIMATE_EXTRA -> {
            context.resources.getText(R.string.status_estimate_extra)
        }
        STATUS_PAYMENT_FINISH -> {
            context.resources.getText(R.string.status_payment)
        }
        STATUS_PAYMENT_EXTRA_FINISH -> {
           context.resources.getText(R.string.status_payment_extra)
        }
        STATUS_VISIT -> {
            context.resources.getText(R.string.status_visit)
        }
        STATUS_WORKING -> {
            context.resources.getText(R.string.status_working)
        }
        STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL, STATUS_CANCEL -> {
            context.resources.getText(R.string.status_cancel)
        }
        STATUS_WORK_COMPLETE, STATUS_WORK_COMPLETE_NEED_EXTRA -> {
            context.resources.getText(R.string.status_complete)

        }
        STATUS_CUSTOMER_CHANGE_DATETIME -> {
            context.resources.getText(R.string.common_type_request_user_change_date)
        }


      else -> {
          ""
      }
  }

}

fun loadStatusOfferColor(status: Int) : Color {
    return when (status) {

        STATUS_VISIT-> {
            Yellow
        }
        STATUS_WORKING -> {
            Blue
        }
        STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL, STATUS_CANCEL -> {
            Red
        }
        else  -> {
            GreenMain
        }

    }

}


fun offerDesireDate(date: String?): String {
    date?.let {
        return "${getDateOfMonth(date)} ${getDateOfWeek(date)}"


    }
    return ""
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