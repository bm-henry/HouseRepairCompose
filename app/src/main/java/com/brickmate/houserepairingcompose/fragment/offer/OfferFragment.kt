package com.brickmate.houserepairingcompose.fragment.offer

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseToolBarFragment
import com.brickmate.houserepairingcompose.ui_component.SearchBar
import com.brickmate.houserepairingcompose.ui_component.offer.AppRecyclerView
import com.brickmate.houserepairingcompose.ui_component.offer.ItemShimmerOffer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OfferFragment : BaseToolBarFragment<OfferViewModel>() {
    override fun getLayoutId() = R.layout.fragment_offer

    override fun composeLayoutID() = R.id.composeContainer_order

    override val viewModel: OfferViewModel by viewModels()

    override var fragmentTitle: String? = "집수리 닷컴"

    override val shouldShowHomeBtn: Boolean = true

    private var job: Job? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchListOffer(keyword = String())

    }

    @Composable
    override fun ComposableView() {

        OrderBody(modifier = Modifier)
    }


    @Composable
    private fun OrderBody(modifier: Modifier = Modifier) {
        val listState = rememberLazyListState()
        var searchText by rememberSaveable { mutableStateOf("") }
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    SearchBar(
                        modifier = Modifier
                            .weight(1f)
                            .height(36.dp),
                        searchText = searchText,
                        onTextChange = {
                            searchText = it
                            viewModel.clearCurrentListOffer()
                            lifecycleScope.launch {
                                delay(1000)
                                fetchListOffer(it)
                            }

                        }
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_search_gray),
                        contentDescription = ""
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
                AppRecyclerView(
                    modifier = Modifier,
                    shimmerView= { ItemShimmerOffer() },
                    isLoading = shouldShowShimmerEffect.value,
                    itemData = viewModel.offer,
                    onLoadMore = {
                        viewModel.inCreasePage()
                        Log.d("BM_Henry", "onLoadMore: ")
                        fetchListOffer(searchText)
                    }, listState = listState
                )
            }
        }
    }


    private fun fetchListOffer(keyword: String) {
        Log.d("BM_Henry", "fetchListOffer: ")
        viewModel.getListOfferHome(keyword = keyword)
    }

    companion object {
        fun createInstance() = OfferFragment()
    }


}
