package com.example.raghav.roomdatabasebyshiv.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by raghav on 22/12/17.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> userList();

    @Insert
    void userDataInsert(User user);

    @Update
    void updateUserData(User user);

    @Delete
    void deleteUserData(User user);
}
