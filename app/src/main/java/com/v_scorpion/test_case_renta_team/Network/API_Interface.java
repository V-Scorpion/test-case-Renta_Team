package com.v_scorpion.test_case_renta_team.Network;

import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoRequest;
import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public interface API_Interface {

    @GET("api/users")
    public Call<PojoRequest> getUsers();
}
