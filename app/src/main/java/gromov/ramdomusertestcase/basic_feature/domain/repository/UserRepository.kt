package gromov.ramdomusertestcase.basic_feature.domain.repository

import gromov.ramdomusertestcase.basic_feature.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getSavedUsers(): Flow<List<User>>

    suspend fun getRandomUsers(): List<User>

    suspend fun getUserDetails(id: String)

}