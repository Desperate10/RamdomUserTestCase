package gromov.ramdomusertestcase.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gromov.ramdomusertestcase.basic_feature.data.local.dao.UserDao
import gromov.ramdomusertestcase.basic_feature.data.local.dao.UserRemoteKeysDao
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserRemoteKeys

@Database(
    entities = [UserDbModel::class, UserRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    abstract val remoteKeys: UserRemoteKeysDao
}