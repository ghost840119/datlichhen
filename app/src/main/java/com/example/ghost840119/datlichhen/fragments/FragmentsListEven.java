package com.example.ghost840119.datlichhen.fragments;

import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ghost840119.datlichhen.R;
import com.example.ghost840119.datlichhen.adapter.EventAdapter;
import com.example.ghost840119.datlichhen.model.Event;

import java.util.ArrayList;


/**
 * Created by ghost840119 on 6/9/2017.
 */

public class FragmentsListEven  extends Fragment  {


    ListView listEvent;
    ArrayList<Event> arrayEvent;
    EventAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_even_layout, container,false);
        listEvent = (ListView)view.findViewById(R.id.listEvent);
        insertList();
        return view;
    }
    private void insertList(){
        arrayEvent = new ArrayList<>();
        arrayEvent.add(new Event("Event 1","17hpm","hcm"));
        arrayEvent.add(new Event("Event 1","17hpm","hcm"));
        arrayEvent.add(new Event("Event 1","17hpm","hcm"));
        arrayEvent.add(new Event("Event 1","17hpm","hcm"));
        arrayEvent.add(new Event("Event 1","17hpm","hcm"));
        adapter = new EventAdapter(getActivity(),R.layout.event_adapter_layout,arrayEvent);

        Log.e("Fragmentlist",""+adapter.getCount());
        listEvent.setAdapter(adapter);
    }





}
