package gromov.ramdomusertestcase.basic_feature.data.mapper

import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel
import gromov.ramdomusertestcase.basic_feature.data.remote.model.DataUser
import gromov.ramdomusertestcase.basic_feature.domain.model.User

fun DataUser.toDomainModel() = User(
    id = login.uuid,
    name = name.name,
    surname = name.surname,
    email = email,
    phone = phone,
    picture = image.imageUrl,
    city = location.city,
    country = location.country
)

fun UserDbModel.toDomainModel() = User(
    id = id,
    name = name,
    surname = surname,
    email = email,
    phone = phone,
    picture = picture,
    city = city,
    country = country
)

fun User.toEntityModel() = UserDbModel(
    id = id,
    name = name,
    surname = surname,
    email = email,
    phone = phone,
    picture = picture,
    city = city,
    country = country
)
