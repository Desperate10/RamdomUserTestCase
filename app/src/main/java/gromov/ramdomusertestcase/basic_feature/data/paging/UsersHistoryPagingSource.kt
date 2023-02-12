package gromov.ramdomusertestcase.basic_feature.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gromov.ramdomusertestcase.app.database.AppDatabase
import gromov.ramdomusertestcase.basic_feature.data.mapper.toDomainModel
import gromov.ramdomusertestcase.basic_feature.domain.model.User

class UsersHistoryPagingSource(
    private val usersDb: AppDatabase
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val currentPage = params.key ?: 0
        return try {
            val users = usersDb.userDao.getSavedUsers(TWENTY_USERS, currentPage * TWENTY_USERS)
            if (users.isNotEmpty()) {
                LoadResult.Page(
                    data = users.map { it.toDomainModel() },
                    prevKey = if (currentPage == 0) null else currentPage - 1,
                    nextKey = currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val TWENTY_USERS = 20
    }
}