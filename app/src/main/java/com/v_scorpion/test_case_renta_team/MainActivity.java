package com.v_scorpion.test_case_renta_team;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.v_scorpion.test_case_renta_team.DataBase.DataBaseHelper;
import com.v_scorpion.test_case_renta_team.Network.Network_Service_Api;

public class MainActivity extends AppCompatActivity {

    Network_Service_Api network_service_api;
    public  static  DataBaseHelper DBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new Thread(() -> {
            try {
                network_service_api = Network_Service_Api.getInstance();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();

        DBHelper = Room.databaseBuilder(getApplicationContext(), DataBaseHelper.class, "Renta-Team").allowMainThreadQueries().build();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_1,new Fragment_List_Users()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_2,new NavigationFrag()).commit();
    }
}