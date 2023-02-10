package gromov.ramdomusertestcase.basic_feature.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val picture: String,
    val city: String,
    val country: String
) {
    constructor() : this("","","","","","","","")
}
