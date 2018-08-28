package com.example.gymhunt.gymhunt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.utils.MyApplication;

public class WorkoutDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        // components reference
        TextView title_text = (TextView) findViewById(R.id.title_text);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomBoldFont());
    }

    // go back action
    public void goBack(View view) {
        finish();
    }
}
