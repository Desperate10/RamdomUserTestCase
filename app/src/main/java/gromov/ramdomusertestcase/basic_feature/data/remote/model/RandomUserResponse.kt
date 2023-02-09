package gromov.ramdomusertestcase.basic_feature.data.remote.model

import kotlinx.serialization.SerialName

data class RandomUserResponse(

    @SerialName("id")
    val id: String = "",

    @SerialName("first")
    val name: String = "",

    @SerialName("last")
    val surname: String = "",

    @SerialName("email")
    val email: String = "",

    @SerialName("phone")
    val phone: String = "",

    @SerialName("large")
    val picture: String = "",

    @SerialName("city")
    val city: String = "",

    @SerialName("country")
    val country: String = ""
)