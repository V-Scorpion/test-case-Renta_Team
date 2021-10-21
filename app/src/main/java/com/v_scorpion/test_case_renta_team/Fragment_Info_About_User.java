package com.v_scorpion.test_case_renta_team;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.UriLoader;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by v_scorpion on 18.10.2021.
 */
public class Fragment_Info_About_User extends Fragment {

    String LastName;
    String FirstName;
    String Email;
    String Avatar;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_info_about_user, container, false);

        LastName = getArguments().getString("LastName");
        FirstName = getArguments().getString("FirstName");
        Email = getArguments().getString("Email");
        Avatar = getArguments().getString("PIC_url");


        Log.e("TAG", "onCreateView: " + Avatar );

        TextView tv_last_name = fragment.findViewById(R.id.TV_Last_Name);
        TextView tv_first_name = fragment.findViewById(R.id.TV_First_Name);
        TextView tv_email = fragment.findViewById(R.id.TV_Email);
        ImageView im_avatar = fragment.findViewById(R.id.Avatar);

        tv_last_name.setText(LastName);
        tv_first_name.setText(FirstName);
        tv_email.setText(Email);


            Glide.with(requireContext())
                 .load(Avatar)
                    .fitCenter()
                    .into(im_avatar);


        return fragment;
    }

    public static Fragment_Info_About_User newInstance(String LastName, String FirstName, String Email, String PIC_url) {

        Fragment_Info_About_User f = new Fragment_Info_About_User();
        Bundle bundle = new Bundle();
        bundle.putString("LastName", LastName);
        bundle.putString("FirstName", FirstName);
        bundle.putString("Email", Email);
        bundle.putString("PIC_url", PIC_url);
        Log.e("TAG", "newInstance: " + PIC_url );
        f.setArguments(bundle);
        return f;
    }
}
