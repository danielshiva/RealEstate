package com.example.dgconstrution.adapters;

/**
 * Created by J6946657 on 19/2/2018.
 */

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dgconstrution.R;
import com.example.dgconstrution.utils.MyApplication;

public class dashboard_grid_adapter extends BaseAdapter {

    private Context mContext;
    private final String[] category_list;

    public dashboard_grid_adapter(Context context, String[] category_list) {
        this.mContext = context;
        this.category_list = category_list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resources resources = mContext.getResources();

        View gridView;

        if (convertView == null) {

            gridView = new View(mContext);

            // get layout from settings_grid_layout
            gridView = inflater.inflate(R.layout.layout_grid_dashboard, null);

            //Component reference
            ImageView grid_item_img = (ImageView) gridView.findViewById(R.id.grid_item_img);
            TextView grid_item_text = (TextView) gridView.findViewById(R.id.grid_item_text);

            // Get Myapplication context for custom font
            MyApplication sharedData = (MyApplication) mContext.getApplicationContext();
            grid_item_text.setTypeface(sharedData.getCustomLightFont());

            // Set Items name
            grid_item_text.setText(category_list[position]);

            // array list reference from String.xml
            String[] category_list = resources.getStringArray(R.array.category_list);

            // set respective images for category
            if (category_list[position].equals(category_list[0])) {
                grid_item_img.setBackgroundResource(R.drawable.site);
            } else if (category_list[position].equals(category_list[1])) {
                grid_item_img.setBackgroundResource(R.drawable.interior);
            } else if (category_list[position].equals(category_list[2])) {
                grid_item_img.setBackgroundResource(R.drawable.table);
            } else if (category_list[position].equals(category_list[3])) {
                grid_item_img.setBackgroundResource(R.drawable.painting);
            } else if (category_list[position].equals(category_list[4])) {
                grid_item_img.setBackgroundResource(R.drawable.raw);
            } else if (category_list[position].equals(category_list[5])) {
                grid_item_img.setBackgroundResource(R.drawable.landscape);
            } else if (category_list[position].equals(category_list[6])) {
                grid_item_img.setBackgroundResource(R.drawable.contactus);
            } else if (category_list[position].equals(category_list[7])) {
                grid_item_img.setBackgroundResource(R.drawable.aboutus);
            } else {
                Log.d("default", "");
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
