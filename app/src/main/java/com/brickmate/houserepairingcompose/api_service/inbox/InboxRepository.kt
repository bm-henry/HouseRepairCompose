package com.brickmate.houserepairingcompose.api_service.inbox

import com.brickmate.houserepairingcompose.base.BaseRepository
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.housereapairing.common.model.inbox.Inbox
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InboxRepository @Inject constructor(val inboxService: InboxService) : BaseRepository() {
    suspend fun getInboxList(limit: Int, page: Int): Flow<NetworkResult<List<Inbox>>> {
        return safeApiCallWithShimmer {
            inboxService.getListInbox(limit = limit, page = page)
        }
    }
}