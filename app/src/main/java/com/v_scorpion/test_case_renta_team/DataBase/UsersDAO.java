package com.v_scorpion.test_case_renta_team.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * Created by v_scorpion on 18.10.2021.
 */
@Dao
public interface UsersDAO {

    @Insert
    void addUsers(Users users);

    @Delete
    void deletedUsers(Users users);


    @Query("SELECT * FROM Users")
    Single<List<Users> > getAllUsers();

    @Update
    void setUsers(Users users);
}
