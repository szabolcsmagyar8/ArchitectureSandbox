package com.unidevoes.szabisandbox.di

import com.unidevoes.szabisandbox.repositories.RemoteRepository
import com.unidevoes.szabisandbox.repositories.RepositorySource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    companion object {
        @Singleton
        @Provides
        fun provideRemoteRepository(): RepositorySource {
            return RemoteRepository()
        }
    }
}