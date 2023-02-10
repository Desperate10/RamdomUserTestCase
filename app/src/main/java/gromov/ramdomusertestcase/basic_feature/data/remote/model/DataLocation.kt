package gromov.ramdomusertestcase.basic_feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class DataLocation (

    @SerializedName("city")
    val city: String,

    @SerializedName("country")
    val country: String
)