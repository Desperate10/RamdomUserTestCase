package gromov.ramdomusertestcase.basic_feature.data.repository

import gromov.ramdomusertestcase.app.database.AppDatabase
import gromov.ramdomusertestcase.basic_feature.data.mapper.toDomainModel
import gromov.ramdomusertestcase.basic_feature.data.mapper.toEntityModel
import gromov.ramdomusertestcase.basic_feature.data.remote.api.UserApi
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val db: AppDatabase
) : UserRepository {

    override fun getSavedUsers(): Flow<List<User>> {
        TODO("Not yet implemented")
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

    override suspend fun getUserDetails(id: String) {
        TODO("Not yet implemented")
    }
}