package design.root.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import design.root.entity.UserEntity;

/**
 * Created by Administrator on 2018/1/25.
 */
@Dao
public interface UserEntityDao {
    @Query("SELECT * FROM users WHERE username IN(:username) And password IN(:password)")
    List<UserEntity> checkUserName(String username, String password);

    @Insert
    void insert(UserEntity userEntity);
}
