package gromov.ramdomusertestcase.basic_feature.data.remote.api

import gromov.ramdomusertestcase.basic_feature.data.remote.model.RandomUserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("?random=20")
    suspend fun getRandomUsers(): RandomUserResponse
}