package com.example.ghost840119.datlichhen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ghost840119.datlichhen.R;
import com.example.ghost840119.datlichhen.model.Event;

import java.util.List;

/**
 * Created by ghost840119 on 6/9/2017.
 */

public class EventAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Event> listEvent;

    public EventAdapter() {
    }

    public EventAdapter(Context context, int layout, List<Event> listEvent) {
        this.context = context;
        this.layout = layout;
        this.listEvent = listEvent;
    }

    @Override
    public int getCount() {
        return listEvent.size();
    }

    @Override
    public Object getItem(int position) {
        return listEvent.get(position);
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
        TextView tv_nameEvent = (TextView) convertView.findViewById(R.id.tv_nameEvent);
        TextView tv_timeEvent = (TextView) convertView.findViewById(R.id.tv_timeEvent);
        TextView tv_addressEvent = (TextView) convertView.findViewById(R.id.tv_addressEvent);

        //gán giá trị
        Event event = listEvent.get(position);
        tv_nameEvent.setText(event.getNameEvent());
        tv_timeEvent.setText(event.getDataEvent());
        tv_addressEvent.setText(event.getAddressEvent());

        return convertView;
    }
}
