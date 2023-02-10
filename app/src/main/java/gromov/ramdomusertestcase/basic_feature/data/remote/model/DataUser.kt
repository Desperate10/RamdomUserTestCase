package gromov.ramdomusertestcase.basic_feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("login") val login: DataUuid,
    @SerializedName("picture") val image: DataImageUrl,
    @SerializedName("name") val name: DataName,
    @SerializedName("phone") val phone: String,
    @SerializedName("location") val location: DataLocation,
    @SerializedName("email") val email: String
)
