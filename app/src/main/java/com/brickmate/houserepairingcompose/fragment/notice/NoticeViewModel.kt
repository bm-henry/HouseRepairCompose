package com.brickmate.houserepairingcompose.fragment.notice

import androidx.compose.runtime.mutableStateListOf
import com.brickmate.houserepairingcompose.api_service.inbox.InboxRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.util.Constant.LIMIT_GET_ALERT
import com.housereapairing.common.model.inbox.Inbox
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(val inboxRepository: InboxRepository) : BaseViewModel() {

    private var inboxs = mutableStateListOf<Inbox>()
    val _inboxs=inboxs
    private var _page: Int = 1
    fun clearCurrentListOffer() {
        _page =1
        _inboxs.clear()


    }

    fun inCreasePage() {
        _page++
    }
    fun getListInbox(  limit  : Int= LIMIT_GET_ALERT) {
        startCallApi {
            inboxRepository.getInboxList(page = _page, limit = limit).collect { it ->
                handleInternetResponse(it).value?.let {inbox ->
                    inboxs.addAll(inbox)

                }

            }

        }



    }
}