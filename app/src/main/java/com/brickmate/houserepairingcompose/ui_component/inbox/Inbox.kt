package com.brickmate.houserepairingcompose.ui_component.inbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.screen.theme.Gray100
import com.brickmate.houserepairingcompose.screen.theme.Green200
import com.valentinilk.shimmer.shimmer

@Composable
fun ItemInboxShimmer(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shimmer(),
        ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Column(Modifier.weight(1f)) {
                Spacer(modifier = Modifier.height(6.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .height(24.dp)
                            .fillMaxWidth(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Gray100)
                    ) {

                    }


                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .weight(0.5f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Gray100)
                    ) {

                    }
                    Spacer(modifier = Modifier.weight(0.5f))
                }
            }

        }

    }
}

@Composable
@Preview
fun PreviewShimmerInbox(){
    ItemInboxShimmer()
}