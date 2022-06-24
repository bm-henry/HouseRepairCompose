package com.brickmate.houserepairingcompose.fragment.notice

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseFragment
import com.brickmate.houserepairingcompose.ui_component.inbox.ItemInboxShimmer
import com.brickmate.houserepairingcompose.ui_component.offer.AppRecyclerView
import com.brickmate.houserepairingcompose.ui_component.offer.ItemOffer
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoticeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class NoticeFragment : BaseFragment<NoticeViewModel>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListInbox()
    }



    override fun getLayoutId() = R.layout.fragment_notice

    override fun composeLayoutID(): Int? = R.id.composeContainer_notice

    @Composable
    override fun ComposableView() {
        val listState = rememberLazyListState()
        AppRecyclerView(
            modifier = Modifier,
            shimmerView = {ItemInboxShimmer()},
            isLoading = shouldShowShimmerEffect.value,
            itemData = viewModel._inboxs,
            onLoadMore = {
                viewModel.inCreasePage()
                Log.d("BM_Henry", "onLoadMore: ")
                viewModel.getListInbox()
            }, listState = listState
        )
    }

    override var fragmentTitle : String?= "알림"
    override val viewModel: NoticeViewModel by viewModels()
    override val shouldShowHomeBtn: Boolean = false
    override val shouldShowToolBar: Boolean = true
}