package com.v_scorpion.test_case_renta_team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.v_scorpion.test_case_renta_team.Network.Network_Service_Api;
import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoUsers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public class Fragment_List_Users extends Fragment {

    private List<PojoUsers> users_info;
    ListView gridView;
    ConstraintLayout layout;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_list_of_user, container, false);

        layout = fragment.findViewById(R.id.content_lay);

        users_info = new ArrayList<>();
        Network_Service_Api.getInstance().getUsersInfo(this);

        gridView = fragment.findViewById(R.id.List_View);

        return fragment;
    }

    public void getUserInfo(List<PojoUsers> items) {
        users_info.clear();
        users_info = items;
        Custom_Adapter_Users_Info adapter = new Custom_Adapter_Users_Info(getContext(),users_info);
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);
    }
}
