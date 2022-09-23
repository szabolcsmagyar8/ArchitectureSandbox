package com.unidevoes.szabisandbox.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unidevoes.szabisandbox.Employee
import com.unidevoes.szabisandbox.Result
import com.unidevoes.szabisandbox.usecase.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getQuotesUseCase: GetQuotesUseCase): ViewModel() {
    private val _employees = MutableLiveData<List<Employee>>()
    private val _quotes = MutableLiveData<List<Result>>()

    val employees: LiveData<List<Employee>> = _employees
    val quotes: LiveData<List<Result>> = _quotes

    fun getEmployees() {
        viewModelScope.launch {
            getQuotesUseCase.invoke().onSuccess {
                _quotes.value = it.results
            }.onFailure {
                // TODO handle error state
            }
        }
    }
}
