package gromov.ramdomusertestcase.basic_feature.data.remote.api

import gromov.ramdomusertestcase.basic_feature.data.remote.model.RandomUserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface UserApi {

    @GET("?results=$TWENTY_USERS")
    suspend fun getRandomUsers(): RandomUserResponse

    companion object {
        const val TWENTY_USERS = 20
    }
}