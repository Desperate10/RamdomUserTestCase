package gromov.ramdomusertestcase.basic_feature.presentation.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetRandomUsersUseCase
import gromov.ramdomusertestcase.basic_feature.presentation.mapper.toPresentationModel
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getRandomUsersUseCase: GetRandomUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow(UserState())
    val users: StateFlow<UserState> = _users

    fun getRandomUsers() {
        viewModelScope.launch {
            _users.emit(UserState(isLoading = true))
            getRandomUsersUseCase()
                .onSuccess { users ->
                    _users.emit(
                        UserState(
                            isLoading = false,
                            users = users.map { it.toPresentationModel() })
                    )
                }
                .onFailure {
                    _users.emit(UserState(isError = true))
                }
        }
    }
}