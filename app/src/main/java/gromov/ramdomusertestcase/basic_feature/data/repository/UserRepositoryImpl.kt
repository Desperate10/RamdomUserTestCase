package gromov.ramdomusertestcase.basic_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import gromov.ramdomusertestcase.app.database.AppDatabase
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel
import gromov.ramdomusertestcase.basic_feature.data.mapper.toDomainModel
import gromov.ramdomusertestcase.basic_feature.data.mapper.toEntityModel
import gromov.ramdomusertestcase.basic_feature.data.paging.UsersHistoryPagingSource
import gromov.ramdomusertestcase.basic_feature.data.remote.api.UserApi
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val db: AppDatabase
) : UserRepository {

    override fun getSavedUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                UsersHistoryPagingSource(db)
            }
        ).flow
    }

    override suspend fun getRandomUsers(): List<User> {
        return userApi
            .getRandomUsers().results
            .map {
                it.toDomainModel()
            }.also { users->
                db.userDao.insertAll(users.map { user ->
                    user.toEntityModel()
                })
            }
    }

    override suspend fun getUserDetails(id: String): User {
        return db.userDao.getUser(id)
            .toDomainModel()
    }
}