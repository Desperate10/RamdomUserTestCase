package gromov.ramdomusertestcase.basic_feature.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gromov.ramdomusertestcase.basic_feature.data.remote.api.UserApi
import gromov.ramdomusertestcase.basic_feature.data.repository.UserRepositoryImpl
import gromov.ramdomusertestcase.basic_feature.domain.repository.UserRepository
import gromov.ramdomusertestcase.basic_feature.domain.usecase.GetRandomUsersUseCase
import gromov.ramdomusertestcase.basic_feature.domain.usecase.getRandomUsers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RandomUserModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object RandomUserModule {

    @Provides
    @Singleton
    fun provideRandomUserApi(
        retrofit: Retrofit
    ): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    fun provideGetRandomUserUseCase(
        userRepository: UserRepository
    ): GetRandomUsersUseCase {
        return GetRandomUsersUseCase {
            getRandomUsers(userRepository)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindRandomUserRepository(impl: UserRepositoryImpl): UserRepository
    }
}