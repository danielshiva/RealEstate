package com.example.dgconstrution;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dgconstrution.utils.MyApplication;

public class DetailWork extends Activity {

    private TextView title_text;
    private TextView imageText;
    //private TextView textHeader;
    private TextView textDetail;
    private TextView priceDetail;
    String listTypeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_work);

        //Receiving data's from Previous screen
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            listTypeName = extras.getString("listTypeName");
        }

        // components refernce
        title_text = (TextView) findViewById(R.id.title_text);
        imageText = (TextView) findViewById(R.id.imageText);
        //textHeader = (TextView) findViewById(R.id.textHeader);
        textDetail = (TextView) findViewById(R.id.textDetail);
        priceDetail = (TextView) findViewById(R.id.priceDetail);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomRegularFont());
        imageText.setTypeface(sharedData.getCustomRegularFont());
        //textHeader.setTypeface(sharedData.getCustomRegularFont());
        textDetail.setTypeface(sharedData.getCustomLightFont());

        // update data call
        updateTableWorkData(listTypeName);
    }

    // update data's as per list title
    private void updateTableWorkData(String listTypeName) {
        String[] table_works_list = getResources().getStringArray(R.array.table_works_list);
        String[] site_category_list = getResources().getStringArray(R.array.site_works_list);
        switch (listTypeName) {
            //Table works
            case "Planning":
                imageText.setText(table_works_list[0].toString());
                title_text.setText(table_works_list[0].toString());
                textDetail.setText(getString(R.string.table_planning));
                priceDetail.setText(getString(R.string.planning_2d));
                break;
            case "Elevations":
                imageText.setText(table_works_list[1].toString());
                title_text.setText(table_works_list[1].toString());
                textDetail.setText(getString(R.string.table_elevations));
                priceDetail.setText(getString(R.string.elevations_price));
                break;
            case "Estimations":
                imageText.setText(table_works_list[2].toString());
                title_text.setText(table_works_list[2].toString());
                textDetail.setText(getString(R.string.table_estimations));
                priceDetail.setText(getString(R.string.estimations_price));
                break;
            case "Consulting":
                imageText.setText(table_works_list[3].toString());
                title_text.setText(table_works_list[3].toString());
                textDetail.setText(getString(R.string.table_consulting));
                priceDetail.setText(getString(R.string.consulting_price));
                break;
            // site works
            case "Budget Homes":
                imageText.setText(site_category_list[0].toString());
                title_text.setText(site_category_list[0].toString());
                textDetail.setText(getString(R.string.site_budgethomes));
                priceDetail.setText(getString(R.string.budgethomes_price));
                break;
            case "Apartments":
                imageText.setText(site_category_list[1].toString());
                title_text.setText(site_category_list[1].toString());
                textDetail.setText(getString(R.string.site_apartments));
                priceDetail.setText(getString(R.string.apartments_price));
                break;
            case "Premium Villas":
                imageText.setText(site_category_list[2].toString());
                title_text.setText(site_category_list[2].toString());
                textDetail.setText(getString(R.string.site_premium));
                priceDetail.setText(getString(R.string.premium_price));
                break;
            case "Luxury Villas":
                imageText.setText(site_category_list[3].toString());
                title_text.setText(site_category_list[3].toString());
                textDetail.setText(getString(R.string.site_luxary));
                priceDetail.setText(getString(R.string.luxary_price));
                break;
            case "Commercial Buildings":
                imageText.setText(site_category_list[3].toString());
                title_text.setText(site_category_list[3].toString());
                textDetail.setText(getString(R.string.site_commercial));
                priceDetail.setText(getString(R.string.commercial_price));
                break;
            default:
                break;
        }
    }

    // action back
    public void goBack(View view) {
        finish();
    }
}
