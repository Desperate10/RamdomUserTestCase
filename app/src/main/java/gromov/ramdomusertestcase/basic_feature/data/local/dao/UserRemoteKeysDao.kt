package gromov.ramdomusertestcase.basic_feature.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gromov.ramdomusertestcase.basic_feature.data.local.entity.UserRemoteKeys

@Dao
interface UserRemoteKeysDao {

    @Query("SELECT * FROM remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: String) : UserRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRemoteKeys(remoteKeys: List<UserRemoteKeys>)

    @Query("DELETE FROM remote_keys_table")
    suspend fun deleteRemoteKeys()

}