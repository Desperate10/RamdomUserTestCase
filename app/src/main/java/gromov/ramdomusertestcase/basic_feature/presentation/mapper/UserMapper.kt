package gromov.ramdomusertestcase.basic_feature.presentation.mapper

import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel
import gromov.ramdomusertestcase.basic_feature.domain.model.User
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDetailDisplayable
import gromov.ramdomusertestcase.basic_feature.presentation.model.UserDisplayable

fun User.toPresentationModel() = UserDisplayable(
    id = id,
    name = name,
    surname = surname,
    photo = picture,
)

fun User.toDetailPresentationModel() = UserDetailDisplayable(
    id = id,
    name = name,
    surname = surname,
    email = email,
    phone = phone,
    picture = picture,
    city = city,
    country = country
)