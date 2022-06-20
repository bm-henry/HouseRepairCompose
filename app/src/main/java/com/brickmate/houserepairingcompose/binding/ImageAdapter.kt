package com.housereapairing.common.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.brickmate.houserepairingcompose.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("setArrowPolygon")
fun setArrowPolygon(imageView: ImageView, model: Boolean?) {
    model?.let {
        imageView.setImageResource(
            if (it) R.drawable.ic_polygon_up_24
            else R.drawable.ic_polygon_down_24
        )
    }
}

@BindingAdapter("backgroundScheduleState")
fun backgroundScheduleState(view: View, boolean: Boolean?) {

    if (view is TextView) {
        view.background =
            ContextCompat.getDrawable(view.context, R.drawable.border_rectangle_corner_34)

        boolean?.let {
            if (boolean) {
                view.background.setTint(
                    ContextCompat.getColor(
                        view.context,
                        R.color.cyan_9_percent
                    )
                )
                view.setTextColor(ContextCompat.getColor(view.context, R.color.cyan_100_percent))
            } else {
                view.background.setTint(
                    ContextCompat.getColor(
                        view.context,
                        R.color.gray_transparent_20
                    )
                )
                view.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.text_gray_100_percent
                    )
                )

            }
        }
    }

    if (view is ConstraintLayout) {
        view.background =
            ContextCompat.getDrawable(view.context, R.drawable.border_rectangle_corner_4)
        boolean?.let {
            if (boolean) {
                view.background.setTint(
                    ContextCompat.getColor(
                        view.context,
                        R.color.cyan_9_percent
                    )
                )
            } else {
                view.background.setTint(
                    ContextCompat.getColor(
                        view.context,
                        R.color.gray_transparent_20
                    )
                )

            }
        }
    }
}

@BindingAdapter("loadImageUrlTransform")
fun loadImageUrlTransform(view: View, url: String?) {
    if (!url.isNullOrEmpty() && (view is ImageView)) {
        Glide.with(view.context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.transform_color)
                    .error(R.drawable.img_empty_imgage)
            )
            .into(view)
        view.rootView.requestLayout()
    }
}

@BindingAdapter("loadImageUrl")
fun loadImageUrl(view: View, url: String?) {

    if (!url.isNullOrEmpty() && (view is ImageView)) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.img_empty_imgage)
            .centerCrop()
            .into(view)
    } else {
        Glide.with(view.context)
            .load("")
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.img_empty_imgage)
            .centerCrop()
            .into(view as ImageView)
    }
}

@BindingAdapter("loadCircleImageUrl")
fun loadCircleImageUrl(view: ImageView, url: String?) {

    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.img_empty_imgage)
            .centerCrop()
            .into(view)
    } else {
        Glide.with(view.context)
            .load("")
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.img_empty_imgage)
            .centerCrop()
            .into(view as ImageView)
    }
}

