package gromov.ramdomusertestcase.basic_feature.presentation.model

import gromov.ramdomusertestcase.basic_feature.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val isError: Boolean = false
)
