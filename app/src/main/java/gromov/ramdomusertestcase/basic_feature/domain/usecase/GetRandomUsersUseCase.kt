package gromov.ramdomusertestcase.basic_feature.domain.usecase

import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository

fun interface GetRandomUsersUseCase : suspend () -> List<User>

suspend fun getRandomUsers(
    userRepository: UserRepository
): List<User> = //resultOf {
    userRepository.getRandomUsers()
//}
