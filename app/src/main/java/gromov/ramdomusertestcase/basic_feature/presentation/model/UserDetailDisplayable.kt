package gromov.ramdomusertestcase.basic_feature.presentation.model

data class UserDetailDisplayable(
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
