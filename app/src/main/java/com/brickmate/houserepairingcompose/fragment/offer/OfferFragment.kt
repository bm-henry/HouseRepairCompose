package com.brickmate.houserepairingcompose.fragment.offer

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseToolBarFragment
import com.brickmate.houserepairingcompose.enum.OfferStatus
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.ui_component.offer.ItemShimmerOffer
import com.brickmate.houserepairingcompose.ui_component.offer.OfferList
import com.brickmate.houserepairingcompose.util.Constant.LIMIT_GET_OFFER
import com.brickmate.houserepairingcompose.util.Util.getStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfferFragment : BaseToolBarFragment<OfferViewModel>() {
    override fun getLayoutId() = R.layout.fragment_offer

    override fun composeLayoutID() = R.id.composeContainer_order

    override val viewModel: OfferViewModel by viewModels()

    override var fragmentTitle: String? = "집수리 닷컴"

    override val shouldShowHomeBtn: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListOfferHome(keyword = "")
    }

    @Composable
    override fun ComposableView() {
        super.ComposableView()
        OrderBody()


    }

    @Composable
    private fun OrderBody(modifier: Modifier = Modifier) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                OfferList(modifier =Modifier, isLoading =shouldShowShimmerEffect.value,offers = viewModel.offer.value, onLoadMore = {
                    viewModel.getListOfferHome(keyword = "", page = viewModel.page++)
                })
            }
        }
    }


    companion object {
        fun createInstance() = OfferFragment()
    }




}
