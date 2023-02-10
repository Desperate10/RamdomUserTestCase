package gromov.ramdomusertestcase.basic_feature.domain.usecase

import androidx.paging.PagingData
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

fun interface GetUsersHistoryUseCase : suspend () -> Flow<PagingData<User>>

fun getUsersHistory(
    userRepository: UserRepository
): Flow<PagingData<User>> =
    userRepository.getSavedUsers()