package com.example.ghost840119.datlichhen.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ghost840119.datlichhen.R;
import com.example.ghost840119.datlichhen.model.ItemSlideMenu;

import java.util.List;

/**
 * Created by ghost840119 on 6/8/2017.
 */

public class SlideMenuAdapter extends BaseAdapter {

    private Context context;
    private List<ItemSlideMenu> listAdapter;

    public SlideMenuAdapter(Context context, List<ItemSlideMenu> listAdapter) {
        this.context = context;
        this.listAdapter = listAdapter;
    }

    @Override
    public int getCount() {
        return listAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        return listAdapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(context,R.layout.menu_layout,null);
        ImageView imgItem = (ImageView) v.findViewById(R.id.item_menu);
        TextView tvItem = (TextView) v.findViewById(R.id.tv_name);

        ItemSlideMenu itemSlideMenu = listAdapter.get(position);
        imgItem.setImageResource(itemSlideMenu.getItem_img());
        tvItem.setText(itemSlideMenu.getItem_title());
        return null;
    }
}
