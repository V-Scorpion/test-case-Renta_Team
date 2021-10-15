package com.v_scorpion.test_case_renta_team.Network;

import com.v_scorpion.test_case_renta_team.PojoUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public interface API_Interface {

    @GET("https://reqres.in/api/users")
    public Call<ArrayList<PojoUsers>> getUsers();
}
