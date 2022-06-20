package com.housereapairing.common.binding

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.enum.*
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateFromIsoString
import com.brickmate.houserepairingcompose.util.TimeUtil.getDateTimeFromTimestamp

import com.brickmate.houserepairingcompose.model.address.KakaoAddress
import com.brickmate.houserepairingcompose.model.alert.Alert
import com.brickmate.houserepairingcompose.util.TimeUtil.getDayAnTimeView
import com.housereapairing.common.model.inbox.Inbox
import org.jsoup.Jsoup


@BindingAdapter("dateTime")
fun TextView.dateTime(data: Any?) {
    if (data is Inbox) {
        if (data.createdAt != null) {
            val timestamp = getDateFromIsoString(data.createdAt)
            text = getDateTimeFromTimestamp(timestamp)
        }
    } else if (data is Alert) {
        if (data.createdAt != null) {
            val timestamp = getDateFromIsoString(data.createdAt.toString())
            text = getDateTimeFromTimestamp(timestamp)
        }
    }
}

@BindingAdapter("textString")
fun TextView.textString(data: Any?) {
    data?.let {
        text = it.toString()
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("textStringSpace")
fun TextView.textStringSpace(data: KakaoAddress?) {
    data?.roadAddress?.addressName.let {
        text = "            $it"
    }
}


@BindingAdapter("textColorState")
fun TextView.textColorState(boolean: Boolean?) {
    boolean?.let {
        if (boolean) {
            setTextColor(ContextCompat.getColor(rootView.context, R.color.cyan_100_percent))
        } else {
            setTextColor(ContextCompat.getColor(rootView.context, R.color.text_gray_day))
        }
    }
}

@BindingAdapter("textColorStatus")
fun TextView.textColorStatus(status: Int) {
    this.text = findStringForView(status, this.context)
    val background = this.background
    if (background is ShapeDrawable) {
        // cast to 'ShapeDrawable'
        background.paint.color = ContextCompat.getColor(this.context, findColorForStatus(status))
    } else if (background is GradientDrawable) {
        // cast to 'GradientDrawable'
        background.setColor(ContextCompat.getColor(this.context, findColorForStatus(status)))
    }
}

@BindingAdapter("textByStatus")
fun TextView.textByStatus(status: Int) {
    this.text = findStringForView(status, this.context)
}

@BindingAdapter("textAndBackgroundByStatus")
fun TextView.textAndBackgroundByStatus(status: Int) {
    when (status) {
        STATUS_CANCEL, STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL -> {
            this.setTextColor(ContextCompat.getColor(this@textAndBackgroundByStatus.context, R.color.colorTextStatusCancel))
            val background = this.background
            if (background is ShapeDrawable) {
                // cast to 'ShapeDrawable'
                background.paint.color = ContextCompat.getColor(this.context, R.color.colorBackgroundStatusCancel)
            } else if (background is GradientDrawable) {
                // cast to 'GradientDrawable'
                background.setColor(ContextCompat.getColor(this.context, R.color.colorBackgroundStatusCancel))
            }
        }
        else -> {
            this.setTextColor(ContextCompat.getColor(this@textAndBackgroundByStatus.context, R.color.cyan_100_percent))
            val background = this.background
            if (background is ShapeDrawable) {
                // cast to 'ShapeDrawable'
                background.paint.color = ContextCompat.getColor(this.context, R.color.cyan_30_percent)
            } else if (background is GradientDrawable) {
                // cast to 'GradientDrawable'
                background.setColor(ContextCompat.getColor(this.context, R.color.cyan_30_percent))
            }
        }
    }
}

@BindingAdapter("textOfferStatus")
fun textOfferStatus(view: TextView, status: Int) {
    view.text = findStringForView(status, view.context)
}

@BindingAdapter("app:parseIsoTime")
fun timeKorea(view: TextView, isoTime: String) {
    val date = getDayAnTimeView(isoTime) // your date
    view.text = date
}

@BindingAdapter("htmlToString")
fun htmlToString(view: TextView, htmlString: String?) {
    view.text = Jsoup.parse(htmlString).text()
}
