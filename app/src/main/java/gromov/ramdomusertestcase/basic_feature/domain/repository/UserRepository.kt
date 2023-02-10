package gromov.ramdomusertestcase.basic_feature.domain.repository

import androidx.paging.PagingData
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getSavedUsers(): Flow<PagingData<User>>

    suspend fun getRandomUsers(): List<User>

    suspend fun getUserDetails(id: String) : User

}