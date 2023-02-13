package gromov.ramdomusertestcase.basic_feature.presentation.screens.user_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetDetailUserInfoUseCase
import gromov.ramdomusertestcase.basic_feature.presentation.mapper.toDetailPresentationModel
import gromov.ramdomusertestcase.basic_feature.presentation.mapper.toPresentationModel
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDetailDisplayable
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDisplayable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getDetailUserInfoUseCase: GetDetailUserInfoUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args by lazy { UserDetailFragmentArgs.fromSavedStateHandle(savedStateHandle) }

    private val _user = MutableStateFlow(UserDetailDisplayable())
    val user: StateFlow<UserDetailDisplayable> = _user

    init {
        viewModelScope.launch {
            _user.value = getDetailUserInfoUseCase(args.id)
                .toDetailPresentationModel()
        }

    }
}