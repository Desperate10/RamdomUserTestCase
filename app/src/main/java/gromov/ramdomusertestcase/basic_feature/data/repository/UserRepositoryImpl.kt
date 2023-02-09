package gromov.ramdomusertestcase.basic_feature.data.repository

import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl : UserRepository {

    override fun getSavedUsers(): Flow<List<User>> {
        TODO("Not yet implemented")
    }

    override fun getRandomUsers(): Flow<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserDetails(id: String) {
        TODO("Not yet implemented")
    }
}