package com.brickmate.houserepairingcompose.ui_component.extention

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.enum.*
import com.brickmate.houserepairingcompose.screen.theme.Blue9
import com.brickmate.houserepairingcompose.screen.theme.Green9
import com.brickmate.houserepairingcompose.screen.theme.Red9
import com.brickmate.houserepairingcompose.screen.theme.Yellow9


@Stable
fun Modifier.setBackgroundWithStatus(status: Int) = this.then(
    this
        .clip(RoundedCornerShape(12.dp))
        .background(
            color = when (status) {

                STATUS_VISIT -> {
                    Yellow9
                }
                STATUS_WORKING -> {
                    Blue9
                }
                STATUS_CUSTOMER_CANCEL, STATUS_ENGINEER_CANCEL, STATUS_CANCEL -> {
                    Red9
                }
                else -> {
                    Green9
                }
            }

        )
        .padding(horizontal = 16.dp, vertical = 4.dp)
)