package com.example.gymhunt.gymhunt;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.utils.MyApplication;

public class WorkoutScheduleActivity extends Activity {

    private String[] workoutScheduleArr = new String[]{"Day1", "Day2 (Rest)", "Day3", "Day4 (Rest)", "Day5", "Day6 (Rest)", "Day6 (Rest)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);

        // components reference
        TextView title_text = (TextView) findViewById(R.id.title_text);
        ListView listView = (ListView) findViewById(R.id.listView);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomBoldFont());

        // Set adapter
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, workoutScheduleArr);

        // set adapter to List
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // List workout screen
                getListWorkoutScreen(pos);
            }
        });
    }

    // Redirect based on selection
    private void getListWorkoutScreen(int pos) {

        switch (pos) {
            case 0:
                Intent i = new Intent(WorkoutScheduleActivity.this, DailyWorkoutListActivity.class);
                i.putExtra("dayName", "DAY1");
                startActivity(i);
                break;
            case 1:
                break;
            case 2:
                Intent j = new Intent(WorkoutScheduleActivity.this, DailyWorkoutListActivity.class);
                j.putExtra("dayName", "DAY3");
                startActivity(j);
                break;
            case 3:
                break;
            case 4:
                Intent k = new Intent(WorkoutScheduleActivity.this, DailyWorkoutListActivity.class);
                k.putExtra("dayName", "DAY5");
                startActivity(k);
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    // go back action
    public void goBack(View view) {
        finish();
    }
}
