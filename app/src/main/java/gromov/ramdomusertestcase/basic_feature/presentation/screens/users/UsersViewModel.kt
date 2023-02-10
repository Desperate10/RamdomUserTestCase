package gromov.ramdomusertestcase.basic_feature.presentation.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetRandomUsersUseCase
import gromov.ramdomusertestcase.basic_feature.presentation.model.RandomUsersUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getRandomUsersUseCase: GetRandomUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow(RandomUsersUiState())
    val users: StateFlow<RandomUsersUiState> = _users

    init {
        getRandomUsers()
    }

    fun getRandomUsers() {
        viewModelScope.launch {
            try {
                _users.emit(RandomUsersUiState(true))
                _users.emit(RandomUsersUiState(users = getRandomUsersUseCase()))
            } catch (e: Exception) {
                _users.emit(RandomUsersUiState(error("error")))
            }
        }
    }
}