package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Fitness_Exercises.ExercisesFactory;
import Fitness_Exercises.InterfaceExercisesDataAccess;

public class Trainings extends AppCompatActivity {
private String status;
private ListView listView;
private String exercises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //get BMI from previous activity
        Intent intent = getIntent();
         status = intent.getStringExtra("Status");
        populateListView();

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                if (position == 0){
                  exercises = "Legs";
                }
                else if (position == 1){
                    exercises = "Chest" ;
                }
                else {
                    exercises = "Back With Shoulders" ;
                }
                Intent intent = new Intent(Trainings.this,ExercisesDetails.class);
                intent.putExtra("exercises", exercises);
                intent.putExtra("Status",status);
                startActivity(intent);

            }
        };
        listView.setOnItemClickListener(itemClickListener);

    }

    private void populateListView() {
        ExercisesFactory factory = new ExercisesFactory();
        InterfaceExercisesDataAccess objExercises = factory.getModel();

        String[] cats = objExercises.getExercises();

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                cats);

         listView = findViewById(R.id.ListView);
        listView.setAdapter(listAdapter);


    }

}