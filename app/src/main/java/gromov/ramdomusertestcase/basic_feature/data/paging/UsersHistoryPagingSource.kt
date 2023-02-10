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
        val currentPage = params.key ?: 1
        return try {
            val users = usersDb.userDao.getSavedUsers(20, currentPage * 20)
            if (users.isNotEmpty()) {
                LoadResult.Page(
                    data = users.map { it.toDomainModel() },
                    prevKey = if (currentPage == 1) null else currentPage - 1,
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
}