package gromov.ramdomusertestcase.basic_feature.domain.usecase

import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository

class GetDetailUserInfoUseCase(
    private val repository: UserRepository
) {

    suspend operator fun invoke(id: String): User {
        return repository.getUserDetails(id)
    }
}