package gromov.ramdomusertestcase.basic_feature.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetUsersHistoryUseCase
import gromov.ramdomusertestcase.basic_feature.presentation.model.RandomUsersUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getUsersHistoryUseCase: GetUsersHistoryUseCase
) : ViewModel() {

    private var _users = MutableStateFlow<PagingData<User>>(PagingData.empty())
    val users: StateFlow<PagingData<User>> = _users

    init {
        getSavedUsers()
    }

    private fun getSavedUsers() {
        viewModelScope.launch {
            getUsersHistoryUseCase()
                .cachedIn(viewModelScope)
                .collect { users ->
                    _users.value = users
                }
        }
    }
}