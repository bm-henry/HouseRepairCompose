package com.brickmate.houserepairingcompose.ui_component.offer

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.screen.theme.*
import com.brickmate.houserepairingcompose.ui_component.extention.setBackgroundWithStatus
import com.brickmate.houserepairingcompose.util.TimeUtil
import com.brickmate.houserepairingcompose.util.loadStatusOfferColor
import com.brickmate.houserepairingcompose.util.loadStatusTextOffer
import com.brickmate.houserepairingcompose.util.offerDesireDate
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemOffer(modifier: Modifier = Modifier, offerItem: Offer) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, GreenMain),
        shape = RoundedCornerShape(5.dp),
        onClick = {

        }

    ) {
        offerItem.let { offerItem ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        Modifier
                            .weight(0.7f)
                    ) {
                        offerItem.fullAddress?.let {
                            Text(
                                text = it,
                                style = AppTextStyle.bold14,
                                color = Black,
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.weight(0.6f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "수리요청", style = AppTextStyle.bold10, color = Gray100)
                                Spacer(modifier = Modifier.width(5.dp))
                                offerItem.category?.name?.let {
                                    Text(
                                        text = it,
                                        style = AppTextStyle.bold10,
                                        color = Gray100,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(size = 4.dp))
                                            .background(Gray10)
                                            .padding(horizontal = 5.dp, vertical = 5.dp)
                                    )
                                }
                            }


                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.weight(0.6f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "접수시간", style = AppTextStyle.bold10, color = Gray100)
                                Spacer(modifier = Modifier.width(5.dp))
                                offerItem.createdAt?.let {
                                    Text(
                                        text = TimeUtil.getDayAnTimeView(it),
                                        style = AppTextStyle.bold10,
                                        color = Gray100,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(size = 4.dp))
                                            .background(Gray10)
                                            .padding(horizontal = 5.dp, vertical = 5.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier.weight(0.6f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "접수번호", style = AppTextStyle.bold10, color = Gray100)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = offerItem.id.toString(),
                                    style = AppTextStyle.bold10,
                                    color = Gray100,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(size = 4.dp))
                                        .background(Gray10)
                                        .padding(horizontal = 5.dp, vertical = 5.dp)
                                )
                            }
                        }
                    }
                    Column(modifier = Modifier.weight(0.3f)) {
                        offerItem.desiredDate?.let {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = offerDesireDate(it),
                                style = AppTextStyle.medium12,
                                color = Black,
                                textAlign = TextAlign.Right,

                                )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.weight(1f))
                            offerItem.status?.let {
                                Text(
                                    style = AppTextStyle.medium14,
                                    text = loadStatusTextOffer(it, LocalContext.current).toString(),
                                    modifier = Modifier.setBackgroundWithStatus(it),
                                    color = loadStatusOfferColor(it),
                                )
                            }

                        }
                    }

                }


            }
        }

    }
}


@Composable
fun ItemShimmerOffer() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shimmer(),
        border = BorderStroke(1.dp, GreenMain),
        shape = RoundedCornerShape(5.dp),

        ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Column(Modifier.weight(1f)) {
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
                            .height(24.dp)
                            .fillMaxWidth(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Gray100)
                    ) {

                    }
                }

            }
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Gray100)
            )
        }

    }
}


@Preview
@Composable
fun PreItemOffer() {
    ItemOffer(offerItem = Offer(fullAddress = "제목"))

}


@Preview
@Composable
fun PreItemShimmerOffer() {
    ItemShimmerOffer()

}

fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1


@Composable
fun OfferList(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    offers: List<Offer>,
    onLoadMore: () -> Unit
) {

    val listState = rememberLazyListState()

    if (isLoading && offers.isEmpty()) {
        Column() {
            LazyColumn(
                state = listState,
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            )
            {
                items(1) { Spacer(modifier = Modifier.height(12.dp)) }
                items(10) {
                    ItemShimmerOffer()
                }
                items(1) { Spacer(modifier = Modifier.height(12.dp)) }
            }
        }

    } else {
        LazyColumn(
            state = listState,
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        )
        {
                items(1) { Spacer(modifier = Modifier.height(12.dp)) }
                items(offers) { offer ->
                    ItemOffer(offerItem = offer)
                }
                if(isLoading){
                    items(1) { offer ->
                        ItemShimmerOffer()
                    }
                }
                items(1) { Spacer(modifier = Modifier.height(12.dp)) }


        }
    }
    InfiniteListHandler(
        listState, onLoadMore = onLoadMore
    )


}

@Composable
fun InfiniteListHandler(
    listState: LazyListState,
    buffer: Int = 5,
    onLoadMore: () -> Unit
) {
    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            lastVisibleItemIndex > (totalItemsNumber - buffer) && lastVisibleItemIndex != 1
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .distinctUntilChanged()
            .collect {
                if (loadMore.value) {
                    Log.d("VietKhanh", "loadMore: ${loadMore.value}")
                    onLoadMore()
                }
            }
    }
}



