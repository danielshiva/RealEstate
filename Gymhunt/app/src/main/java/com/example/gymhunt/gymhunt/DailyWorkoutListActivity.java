package com.example.gymhunt.gymhunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gymhunt.gymhunt.utils.MyApplication;

public class DailyWorkoutListActivity extends Activity {

    private String[] DAY1 = new String[]{"Barbell Squat", "Barbell Bench Press - Medium Grip", "Pullups", "Standing Military Press", "Barbell Curl", "Ab Roller"};
    private String[] DAY3 = new String[]{"Barbell Deadlift", "Bent Over Barbell Row", "Incline Dumbbell Press", "Side Lateral Raise", "Standing Dumbbell Triceps Extension", "Hammer Curls"};
    private String[] DAY5 = new String[]{"Dumbbell Lunges", "Dips - Triceps Version", "Chin-Up", "Double Kettlebell Push Press", "Seated Calf Raise", "Plate Twist"};
    private ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_workout_list);

        // components reference
        TextView title_text = (TextView) findViewById(R.id.title_text);
        ListView listView = (ListView) findViewById(R.id.listView);

        // Get Myapplication context for custom font
        MyApplication sharedData = (MyApplication) getApplicationContext();
        title_text.setTypeface(sharedData.getCustomBoldFont());

        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String dayName = bundle.getString("dayName");

        // Set adapter based on selection
        if (dayName.equals("DAY1")) {
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAY1);
        } else if (dayName.equals("DAY3")) {
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAY3);
        } else {
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DAY5);
        }

        // set adapter to List
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //ItemClicked item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(DailyWorkoutListActivity.this, WorkoutDetailActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });
    }

    // go back action
    public void goBack(View view) {
        finish();
    }
}
