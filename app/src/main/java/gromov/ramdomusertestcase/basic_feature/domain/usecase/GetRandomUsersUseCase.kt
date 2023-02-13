package gromov.ramdomusertestcase.basic_feature.domain.usecase

import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import gromov.ramdomusertestcase.core.extension.resultOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

fun interface GetRandomUsersUseCase : suspend () -> Result<List<User>>

suspend fun getRandomUsers(
    userRepository: UserRepository
): Result<List<User>> = resultOf {
    userRepository.getRandomUsers()
}
