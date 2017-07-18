package com.example.ghost840119.datlichhen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ghost840119.datlichhen.R;
import com.example.ghost840119.datlichhen.model.Friend;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ghost840119 on 6/11/2017.
 */

public class FriendAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Friend> listFriend;

    public FriendAdapter() {
    }

    public FriendAdapter(Context context, int layout, List<Friend> listFriend) {
        this.context = context;
        this.layout = layout;
        this.listFriend = listFriend;
    }

    @Override
    public int getCount() {
        return listFriend.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        //Anh xa
        ImageView imguUser = (ImageView)convertView.findViewById(R.id.imgUser);
        TextView tvUsername = (TextView)convertView.findViewById(R.id.tv_userName);

        //gán dữ liệu
        Friend friend = listFriend.get(position);
        //imguUser.setImageResource(friend.getImgUser());
        tvUsername.setText(friend.getName());

        return convertView;
    }
}
