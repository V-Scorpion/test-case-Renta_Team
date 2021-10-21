package com.v_scorpion.test_case_renta_team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.v_scorpion.test_case_renta_team.DataBase.Users;
import com.v_scorpion.test_case_renta_team.Network.Network_Service_Api;
import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoUsers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
        gridView.setOnItemClickListener((parent, view, position, id) -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_1, Fragment_Info_About_User.newInstance(users_info.get(position).getLastName(), users_info.get(position).getFirstName(), users_info.get(position).getEmail(), users_info.get(position).getAvatar())).addToBackStack(null).commit());

        return fragment;
    }

    public void getUserInfo(List<PojoUsers> items) {
        users_info.clear();
        users_info = items;

        Custom_Adapter_Users_Info adapter = new Custom_Adapter_Users_Info(getContext(), users_info);
        adapter.notifyDataSetChanged();
        gridView.setAdapter(adapter);

        for (int i = 0 ; i < users_info.size();i++) {
            MainActivity.DBHelper.getUsersDAO().addUsers(new Users(users_info.get(i).getEmail(),users_info.get(i).getFirstName(),users_info.get(i).getLastName(),users_info.get(i).getAvatar()));
        }
    }

    public void onErrors(String s) {

        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();

        MainActivity.DBHelper.getUsersDAO().getAllUsers()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Users>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Users> users) {

                        users_info.clear();
                       for (int i= 0; i<users.size();i++){
                           users_info.add(new PojoUsers(users.get(i).getLastName(),users.get(i).getFirstName(),users.get(i).getEmail(),users.get(i).getAvatar()));
                       }

                        Custom_Adapter_Users_Info adapter = new Custom_Adapter_Users_Info(getContext(), users_info);
                        adapter.notifyDataSetChanged();
                        gridView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }
}