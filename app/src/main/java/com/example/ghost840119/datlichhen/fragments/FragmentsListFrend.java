package com.example.ghost840119.datlichhen.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ghost840119.datlichhen.R;
import com.example.ghost840119.datlichhen.adapter.FriendAdapter;
import com.example.ghost840119.datlichhen.model.Friend;

import java.util.ArrayList;

/**
 * Created by ghost840119 on 6/9/2017.
 */

public class FragmentsListFrend extends Fragment {

    ListView listView;
    ArrayList<Friend> listFriend;
    FriendAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_friend_layout,container,false);
        listView = (ListView) view.findViewById(R.id.listFriend);
       /* ((ActionBarActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ActionBarActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);*/
        data();
        insertListView();
        return view;
    }
    private void data(){
        listFriend = new ArrayList<>();
        listFriend.add(new Friend("","The Vuong","tv@yahoo.com"));
        listFriend.add(new Friend("","T V","tv@yahoo.com"));
        listFriend.add(new Friend("","Van A","tv@yahoo.com"));
        listFriend.add(new Friend("","Phu Qui","tv@yahoo.com"));
    }
    private void insertListView(){
        adapter = new FriendAdapter(getActivity(),R.layout.friend_adapter_layout,listFriend);
        listView.setAdapter(adapter);
    }




}
