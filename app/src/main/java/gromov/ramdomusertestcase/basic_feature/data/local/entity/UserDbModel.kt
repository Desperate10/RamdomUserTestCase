package gromov.ramdomusertestcase.basic_feature.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDbModel(
    @PrimaryKey
    val id: String,
    val firstName: String,
    val secondName: String,
    val email: String,
    val phone: String,
    val picture: String,
    val city: String,
    val country: String
)
