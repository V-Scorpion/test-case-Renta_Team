package com.v_scorpion.test_case_renta_team.Network;

import android.util.Log;

import com.v_scorpion.test_case_renta_team.Fragment_info_about_users;
import com.v_scorpion.test_case_renta_team.PojoUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public class Network_Service_Api {

    private static Network_Service_Api mInstance;
    private Retrofit mRetrofit;


    private Network_Service_Api() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static Network_Service_Api getInstance() {
        if (mInstance == null) {
            mInstance = new Network_Service_Api();
        }
        return mInstance;
    }

    public void getUsersInfo ( Fragment_info_about_users context){
        API_Interface api = mRetrofit.create(API_Interface.class);
        Call<ArrayList<PojoUsers>> call  = api.getUsers();

        call.enqueue(new Callback<ArrayList<PojoUsers>>() {
            @Override
            public void onResponse(Call<ArrayList<PojoUsers>> call, Response<ArrayList<PojoUsers>> response) {

                try {
                    if (response.isSuccessful()) {
                        String sd1 = response.body().toString();
                        //передача данных обратно в класс для их обработки
                        context.getUserInfo(response.body());
                    }
                }catch (Exception exception){
                    Log.e("TAG", "onResponse: " + exception.getMessage());
                }

            }

            @Override
            public void onFailure(Call<ArrayList<PojoUsers>> call, Throwable t) {

            }
        });
    }

}
