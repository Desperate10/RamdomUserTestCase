package gromov.ramdomusertestcase.basic_feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class DataName(
    @SerializedName("first")
    val name: String,

    @SerializedName("last")
    val surname: String
)
