package com.unidevoes.szabisandbox.usecase

import com.unidevoes.szabisandbox.repositories.RepositorySource
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: RepositorySource) {
    suspend fun invoke() = repository.getQuotes()
}
