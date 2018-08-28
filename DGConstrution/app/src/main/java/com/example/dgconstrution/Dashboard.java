package com.example.dgconstrution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.dgconstrution.adapters.dashboard_grid_adapter;
import com.example.dgconstrution.utils.MyApplication;

public class Dashboard extends Activity {

    private GridView gridView;
    private String[] category_list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Component reference
        gridView = (GridView) findViewById(R.id.gridView);
        TextView title_text = (TextView) findViewById(R.id.title_text);
        category_list = getResources().getStringArray(R.array.category_list);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomRegularFont());

        // Set adapter to gridview
        dashboard_grid_adapter gridAdapter = new dashboard_grid_adapter(this, category_list);
        gridView.setAdapter(gridAdapter);

        // gridView actions
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Redirecting as per index
                goToDiffCategoryScreen(position);
            }
        });
    }

    // Based on Index moving to different screen
    private void goToDiffCategoryScreen(int position) {

        switch (position) {
            case 0:
                Intent a = new Intent(this, TableWork.class);
                a.putExtra("categories", "SiteWorks");
                a.putExtra("titleName", "Site works");
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(this, TableWork.class);
                b.putExtra("categories", "InteriorWorks");
                b.putExtra("titleName", "Interior works");
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(this, TableWork.class);
                c.putExtra("categories", "TableWorks");
                c.putExtra("titleName", "Table works");
                startActivity(c);
                break;
            case 3:
                Intent d = new Intent(this, TableWork.class);
                d.putExtra("categories", "PaintingWorks");
                d.putExtra("titleName", "Painting works");
                startActivity(d);
                break;
            case 4:
                Intent e = new Intent(this, TableWork.class);
                e.putExtra("categories", "RawWorks");
                e.putExtra("titleName", "Raw materials");
                startActivity(e);
                break;
            case 5:
                Intent f = new Intent(this, TableWork.class);
                f.putExtra("categories", "LandscapeWorks");
                f.putExtra("titleName", "Landscape works");
                startActivity(f);
                break;
            case 6:
                Intent g = new Intent(this, TableWork.class);
                g.putExtra("categories", "ContactWorks");
                g.putExtra("titleName", "Contact Us");
                startActivity(g);
                break;
            case 7:
                Intent h = new Intent(this, TableWork.class);
                h.putExtra("categories", "AboutWorks");
                h.putExtra("titleName", "About Us");
                startActivity(h);
                break;
            default:
                break;
        }
    }
}
