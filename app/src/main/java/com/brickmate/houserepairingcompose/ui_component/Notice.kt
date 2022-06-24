package com.brickmate.houserepairingcompose.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold14
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold8
import com.housereapairing.common.model.inbox.Inbox

@Composable
fun ItemInbox(modifier: Modifier = Modifier, itemInbox: Inbox?) {

        Row(modifier = Modifier
            .fillMaxWidth(), verticalAlignment =Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_red_dot), contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
           Column {
                Row( verticalAlignment = Alignment.CenterVertically) {
                    Text(text = itemInbox?.name ?: "Huy", style = bold14)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = itemInbox?.createdAt ?: "03/24 14:25", style = bold8, color = Color.LightGray)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = itemInbox?.content ?: "수락하지 않은 새 접수건이 있습니다 확인해주세요.", style = bold8, color = Color.LightGray)
                Spacer(modifier = Modifier.height(8.dp))

                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }


}

@Preview
@Composable
fun PreviewItemNotice() {
    ItemInbox(itemInbox = null)
}