package gromov.ramdomusertestcase.basic_feature.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserDbModel

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserDbModel>)

    @Query("SELECT * FROM user_table LIMIT :limit OFFSET :offset")
    suspend fun getSavedUsers(limit: Int, offset: Int) : List<UserDbModel>

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUser(id: String): UserDbModel

}