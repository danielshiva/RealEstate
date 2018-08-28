package com.example.dgconstrution.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dgconstrution.R;
import com.example.dgconstrution.utils.MyApplication;

/**
 * Created by J6946657 on 20/2/2018.
 */

public class list_data_adapter extends BaseAdapter {

    Context context;
    String[] category_list;

    public list_data_adapter(Context context, String[] category_list) {
        this.context = context;
        this.category_list = category_list;
    }

    public class Holder {
        TextView textView;
    }

    @Override
    public int getCount() {
        return category_list.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new Holder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_list, parent, false);

            // Component reference
            viewHolder.textView = (TextView) convertView.findViewById(R.id.txtView1);

            final MyApplication sharedData = (MyApplication) context.getApplicationContext();
            viewHolder.textView.setTypeface(sharedData.getCustomLightFont());

            // Set Items name
            viewHolder.textView.setText(category_list[position]);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Holder) convertView.getTag();
        }

        // Return the completed view to render on screen
        return convertView;
    }

}
