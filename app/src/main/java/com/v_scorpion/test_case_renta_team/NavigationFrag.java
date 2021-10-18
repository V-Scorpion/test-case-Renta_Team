package com.v_scorpion.test_case_renta_team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Created by v_scorpion on 15.10.2021.
 */

public class NavigationFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_fragment,container,false);

        BottomNavigationView navigationView = view.findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bottomNavigation_Users: {
                    getActivity().getSupportFragmentManager().popBackStack();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_1, new Fragment_List_Users()).addToBackStack(null).commit();
                    return true;

                }
                case R.id.bottomNavigation_About: {
                    getActivity().getSupportFragmentManager().popBackStack();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_1, new Fragment_about()).addToBackStack(null).commit();
                    return true;
                }
            }
            return false;
        });
        return  view ;
    }
}
