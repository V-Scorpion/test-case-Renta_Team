package com.v_scorpion.test_case_renta_team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public class Fragment_info_about_users extends Fragment {
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
       View fragment = inflater.inflate(R.layout.fragment_list_of_user,container,false);
       return fragment;
    }

    public void  getUserInfo(ArrayList<PojoUsers> items){

    }
}
