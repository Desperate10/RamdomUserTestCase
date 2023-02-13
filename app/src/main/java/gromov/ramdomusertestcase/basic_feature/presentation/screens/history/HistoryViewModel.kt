package gromov.ramdomusertestcase.basic_feature.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetUsersHistoryUseCase
import gromov.ramdomusertestcase.basic_feature.presentation.mapper.toPresentationModel
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDisplayable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getUsersHistoryUseCase: GetUsersHistoryUseCase
) : ViewModel() {

    private var _users = MutableStateFlow<PagingData<UserDisplayable>>(PagingData.empty())
    val users: StateFlow<PagingData<UserDisplayable>> = _users

    fun getSavedUsers() {
        viewModelScope.launch {
            getUsersHistoryUseCase()
                .cachedIn(viewModelScope)
                .collect { users ->
                    _users.emit(users.map { it.toPresentationModel() })
                }
        }
    }
}