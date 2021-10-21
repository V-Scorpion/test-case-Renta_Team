package com.v_scorpion.test_case_renta_team.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by v_scorpion on 19.10.2021.
 */

@Database(entities = {Users.class},version = 1)
public abstract class DataBaseHelper extends RoomDatabase {

    private static DataBaseHelper INSTANCE;

    /***/
    public abstract UsersDAO getUsersDAO();

}

