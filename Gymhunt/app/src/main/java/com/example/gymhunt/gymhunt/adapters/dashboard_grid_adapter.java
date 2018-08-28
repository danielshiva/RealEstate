package com.example.gymhunt.gymhunt.adapters;


import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.R;
import com.example.gymhunt.gymhunt.utils.MyApplication;


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
            grid_item_text.setTypeface(sharedData.getCustomBoldFont());

            // Set Items name
            grid_item_text.setText(category_list[position]);

            // array list reference from String.xml
            String[] gym_category_list = resources.getStringArray(R.array.gym_category_list);

            // set respective images for category
            if (category_list[position].equals(gym_category_list[0])) {
                grid_item_img.setBackgroundResource(R.drawable.muscle);
            } else if (category_list[position].equals(gym_category_list[1])) {
                grid_item_img.setBackgroundResource(R.drawable.leanbody);
            } else if (category_list[position].equals(gym_category_list[2])) {
                grid_item_img.setBackgroundResource(R.drawable.sixpack);
            } else if (category_list[position].equals(gym_category_list[3])) {
                grid_item_img.setBackgroundResource(R.drawable.fitness);
            } else if (category_list[position].equals(gym_category_list[4])) {
                grid_item_img.setBackgroundResource(R.drawable.nutrition);
            } else if (category_list[position].equals(gym_category_list[5])) {
                grid_item_img.setBackgroundResource(R.drawable.cardio);
            } else {
                Log.d("default", "");
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
