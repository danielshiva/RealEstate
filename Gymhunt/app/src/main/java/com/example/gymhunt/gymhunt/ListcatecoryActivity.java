package com.example.gymhunt.gymhunt;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.utils.MyApplication;

public class ListcatecoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcatecory);

        // components reference
        TextView title_text = (TextView) findViewById(R.id.title_text);
        TextView beginner_text1 = (TextView) findViewById(R.id.beginner_text1);
        TextView intermediate_text1 = (TextView) findViewById(R.id.intermediate_text1);
        TextView advanced_text1 = (TextView) findViewById(R.id.advanced_text1);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomBoldFont());
        beginner_text1.setTypeface(sharedData.getCustomBoldFont());
        intermediate_text1.setTypeface(sharedData.getCustomBoldFont());
        advanced_text1.setTypeface(sharedData.getCustomBoldFont());
    }

    // go to Workout screen
    public void goWorkoutScreen(View view) {
        Intent a = new Intent(this, WorkoutScheduleActivity.class);
        startActivity(a);
    }

    // go back action
    public void goBack(View view) {
        finish();
    }
}
