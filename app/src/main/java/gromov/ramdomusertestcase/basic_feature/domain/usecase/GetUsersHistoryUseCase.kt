package gromov.ramdomusertestcase.basic_feature.domain.usecase

import androidx.paging.PagingData
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import gromov.ramdomusertestcase.core.extension.resultOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException

fun interface GetUsersHistoryUseCase : suspend () -> Flow<PagingData<User>>

fun getUsersHistory(
    userRepository: UserRepository
): Flow<PagingData<User>> =
    userRepository.getSavedUsers()
