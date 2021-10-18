package com.v_scorpion.test_case_renta_team.Network;

import android.util.Log;

import com.v_scorpion.test_case_renta_team.Fragment_List_Users;
import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoRequest;

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
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static Network_Service_Api getInstance() {
        if (mInstance == null) {
            mInstance = new Network_Service_Api();
        }
        return mInstance;
    }

    public void getUsersInfo ( Fragment_List_Users context){
        API_Interface api = mRetrofit.create(API_Interface.class);
        Call<PojoRequest> call  = api.getUsers();

        call.enqueue(new Callback<PojoRequest>() {
            @Override
            public void onResponse(Call<PojoRequest> call, Response<PojoRequest> response) {

                try {
                    if (response.isSuccessful()) {
                        String sd1 = response.body().toString();
                        //передача данных обратно в класс для их обработки
                        context.getUserInfo(response.body().getData());
                    }
                }catch (Exception exception){
                    Log.e("TAG", "onResponse: " + exception.getMessage());
                }

            }

            @Override
            public void onFailure(Call<PojoRequest> call, Throwable t) {
                Log.v("onFailure", "error " + t);
                Log.e("ERROR: ", t.getMessage());

            }
        });
    }

}
