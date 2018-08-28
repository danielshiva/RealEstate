package com.example.gymhunt.gymhunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.adapters.dashboard_grid_adapter;
import com.example.gymhunt.gymhunt.utils.MyApplication;

public class MainActivity extends Activity {

    private GridView gridView;
    private String[] GYM_category_list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // components reference
        gridView = (GridView) findViewById(R.id.gridView);
        TextView title_text = (TextView) findViewById(R.id.title_text);
        GYM_category_list = getResources().getStringArray(R.array.gym_category_list);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomBoldFont());

        // Set adapter to gridview
        dashboard_grid_adapter gridAdapter = new dashboard_grid_adapter(this, GYM_category_list);
        gridView.setAdapter(gridAdapter);

        // gridView actions
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Redirecting as per index
                goToDiffWorkoutScreen(position);
            }
        });
    }

    // Based on Index moving to different screen
    private void goToDiffWorkoutScreen(int position) {

        switch (position) {
            case 0:
                Intent a = new Intent(this, ListcatecoryActivity.class);
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(this, ListcatecoryActivity.class);
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(this, ListcatecoryActivity.class);
                startActivity(c);
                break;
            case 3:
                Intent d = new Intent(this, ListcatecoryActivity.class);
                startActivity(d);
                break;
            case 4:
                Intent e = new Intent(this, ListcatecoryActivity.class);
                startActivity(e);
                break;
            case 5:
                Intent f = new Intent(this, ListcatecoryActivity.class);
                startActivity(f);
                break;
            default:
                break;
        }
    }
}
