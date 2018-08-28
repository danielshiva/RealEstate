package com.example.dgconstrution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.dgconstrution.adapters.list_data_adapter;
import com.example.dgconstrution.utils.MyApplication;


public class TableWork extends Activity {

    ListView listView;
    private String categoryName;
    private String titleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_work);

        //Receiving data's from Previous screen
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            categoryName = extras.getString("categories");
            titleName = extras.getString("titleName");
        }

        //Components reference
        listView = (ListView) findViewById(R.id.listView);
        TextView title_text = (TextView) findViewById(R.id.title_text);

        // set corresponding title
        title_text.setText(titleName);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomRegularFont());

        // Update all data into list
        updateCategoryData(categoryName);

        // gridView actions
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listCategoryName = (String) ((TextView) view.findViewById(R.id.txtView1)).getText();
                // Redirecting as per index
                goToDiffWorkoutScreen(listCategoryName);
            }
        });
    }

    // Data changes based on screens
    private void updateCategoryData(String categoryName) {
        switch (categoryName) {
            case "SiteWorks":
                //get data from string.xml
                String[] site_category_list = getResources().getStringArray(R.array.site_works_list);
                // adapter push
                pushIntoAdapter(site_category_list);
                break;
            case "InteriorWorks":
                //get data from string.xml
                String[] interior_category_list = getResources().getStringArray(R.array.interior_works_list);
                // adapter push
                pushIntoAdapter(interior_category_list);
                break;
            case "TableWorks":
                //get data from string.xml
                String[] table_category_list = getResources().getStringArray(R.array.table_works_list);
                // adapter push
                pushIntoAdapter(table_category_list);
                break;
            case "LandscapeWorks":
                //get data from string.xml
                String[] land_category_list = getResources().getStringArray(R.array.landscape_works_list);
                // adapter push
                pushIntoAdapter(land_category_list);
                break;
            case "RawWorks":
                //get data from string.xml
                String[] raw_category_list = getResources().getStringArray(R.array.raw_works_list);
                // adapter push
                pushIntoAdapter(raw_category_list);
                break;
            case "PaintingWorks":
                //get data from string.xml
                String[] painting_category_list = getResources().getStringArray(R.array.painting_works_list);
                // adapter push
                pushIntoAdapter(painting_category_list);
                break;
            case "ContactWorks":
                //get data from string.xml
                String[] contact_category_list = getResources().getStringArray(R.array.contact_us_list);
                // adapter push
                pushIntoAdapter(contact_category_list);
                break;
            case "AboutWorks":
                //get data from string.xml
                String[] about_category_list = getResources().getStringArray(R.array.about_us_list);
                // adapter push
                pushIntoAdapter(about_category_list);
                break;
            default:
                break;
        }
    }

    // update list data to adapter
    private void pushIntoAdapter(String[] category_list) {
        list_data_adapter adapter = new list_data_adapter(this, category_list);
        listView.setAdapter(adapter);
    }

    // Based on Index moving to different screen
    private void goToDiffWorkoutScreen(String listCategoryName) {
        // pushing to next screen
        Intent a = new Intent(this, DetailWork.class);
        a.putExtra("listTypeName", listCategoryName);
        startActivity(a);
    }

    // action back
    public void goBack(View view) {
        finish();
    }
}
