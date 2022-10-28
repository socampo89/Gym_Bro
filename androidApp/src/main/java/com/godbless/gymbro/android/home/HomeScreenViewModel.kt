package com.godbless.gymbro.android.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.godbless.gymbro.base.None
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.domain.usecases.UserUseCases
import com.godbless.gymbro.user.exception.UserException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val userUseCases: UserUseCases,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    companion object{
        const val userFlowKey = "user"
        const val failureKey = "toastError"
    }

    private val user = savedStateHandle.getStateFlow<User?>(userFlowKey, null)
    private val failure = savedStateHandle.getStateFlow<UserException?>(failureKey, null)

    val state = combine(user, failure){ user, failure ->
        HomeScreenState(
            user = user,
            failure = failure)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeScreenState())

    fun getCurrentUser(){
        viewModelScope.launch {
            when(val response = userUseCases.getCurrentUserUseCase.invoke(None())){
                is Either.Left -> setUserFailure(response.l)
                is Either.Right -> savedStateHandle[userFlowKey] = response.r
            }
        }
    }

    fun setUserFailure(failure : UserException?){
        viewModelScope.launch {
            savedStateHandle[failureKey] = failure
        }
    }

}