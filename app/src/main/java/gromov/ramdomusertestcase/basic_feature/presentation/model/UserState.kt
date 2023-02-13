package gromov.ramdomusertestcase.basic_feature.presentation.model

data class UserState(
    val isLoading: Boolean = false,
    val users: List<UserDisplayable> = emptyList(),
    val isError: Boolean = false
)
