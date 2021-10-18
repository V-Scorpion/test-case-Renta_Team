package com.v_scorpion.test_case_renta_team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.v_scorpion.test_case_renta_team.Pojo_Class.PojoUsers;

import java.util.List;

/**
 * Created by v_scorpion on 15.10.2021.
 */
public class Custom_Adapter_Users_Info extends BaseAdapter {

    Context mContext;
    List<PojoUsers> users;

    public Custom_Adapter_Users_Info(Context mContext, List<PojoUsers> users) {
        this.mContext = mContext;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view , ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_user_info, null);
        }

        TextView tv_famil = view.findViewById(R.id.textView);
        TextView tv_name = view.findViewById(R.id.textView2);

        tv_famil.setText(users.get(position).getLastName());
        tv_name.setText(users.get(position).getFirstName());
        return view;
    }
}
