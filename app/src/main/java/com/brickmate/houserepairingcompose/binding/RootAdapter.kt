package com.brickmate.houserepairingcompose.binding

import android.os.Build
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.util.Util.getScreenWidth


@BindingAdapter("backgroundCyan")
fun setBackgroundCyan(view: View, boolean: Boolean?) {
    if (view is TextView) {
        boolean.let {
            if (boolean == true) {
                view.background.setTint(
                    ContextCompat.getColor(
                        view.context,
                        R.color.cyan_100_percent
                    )
                )
                view.setTextColor(ContextCompat.getColor(view.context, R.color.white))
            } else {
                view.background.setTint(ContextCompat.getColor(view.context, R.color.white))
                view.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.text_gray_100_percent
                    )
                )

            }
        }
    }
}

@BindingAdapter("backgroundGray")
fun setBackgroundGray(view: View, boolean: Boolean) {
    boolean.let {
        view.background.setTint(
            if (boolean) ContextCompat.getColor(view.context, R.color.gray_10_transparent)
            else ContextCompat.getColor(view.context, R.color.white)
        )

    }
}

@BindingAdapter("visibleWhenTrue")
fun visibleWhenTrue(view: View, visible: Boolean?) {
    view.visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleWhenNotNull")
fun visibleWhenNotNull(view: View, visible: Any?) {
    view.visibility = if (visible == null) View.GONE else View.VISIBLE
}

@BindingAdapter("visibleWhenNull")
fun visibleWhenNull(view: View, visible: Any?) {
    view.visibility = if (visible == null) View.VISIBLE else View.GONE
}

@BindingAdapter("visibleWhenFalse")
fun visibleWhenFalse(view: View, visible: Boolean?) {
    view.visibility = if (visible == true) View.GONE else View.VISIBLE
}

@BindingAdapter("visibleWhenNullOrZero")
fun visibleWhenNullOrZero(view: View, status: Int?) {
    view.visibility = if (status == null || status == 0) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibleUnless")
fun invisibleUnless(view: View, visible: Any?) {
    if (visible is Boolean) {
        view.visibility = if (visible == true) View.VISIBLE else View.INVISIBLE
    } else {
        view.visibility = if (visible == null) View.INVISIBLE else View.VISIBLE
    }
}

@BindingAdapter("invisibleUnlessString")
fun invisibleUnlessString(view: View, visible: String?) {
    view.visibility = if (visible == null) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("backgroundHover")
fun backgroundHover(view: View, boolean: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && boolean) {
        val out = TypedValue()
        view.context.theme.resolveAttribute(android.R.attr.selectableItemBackground, out, true)
        view.foreground = ContextCompat.getDrawable(view.context, out.resourceId)
    }

}

@BindingAdapter("matchWidthItem")
fun matchWidthItem(view: View, max: Boolean?) {
    max?.let {
        if (max) {
            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }
}

@BindingAdapter("setHalfWidth")
fun setHalfWidth(view: View, boolean: Boolean) {
    if (view is ConstraintLayout && boolean) {
        val width = getScreenWidth()
        view.layoutParams.width = width / 2
        view.layoutParams.height = width / 2
    }
}

@BindingAdapter("setJustHalfWidth")
fun setJustHalfWidth(view: View, boolean: Boolean) {
    if (boolean) {
        val width = getScreenWidth()
        if (view is TextView) {
            view.maxWidth = width * 70 / 100
            view.minWidth = width * 50 / 100
        }
        //view.layoutParams.width = width * 70 / 100
    }
}

@BindingAdapter("setTwoThirdWidth")
fun setTwoThirdWidth(view: View, boolean: Boolean) {
    if (view is ConstraintLayout && boolean) {
        val width = getScreenWidth()
        view.layoutParams.width = (2f / 3f * width).toInt()
    }
}

