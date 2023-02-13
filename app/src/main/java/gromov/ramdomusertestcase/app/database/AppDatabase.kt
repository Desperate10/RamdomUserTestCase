package gromov.ramdomusertestcase.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gromov.ramdomusertestcase.basic_feature.data.local.dao.UserDao
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel

@Database(
    entities = [UserDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

}