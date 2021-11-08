package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import Fitness_Exercises.Exercises;
import Fitness_Exercises.ExercisesFactory;
import Fitness_Exercises.InterfaceExercisesDataAccess;

public class ExercisesDetails extends AppCompatActivity {
     private String status;
     private String exercises;
     private int position;
    private Spinner spinner;
    private TextView txtDetails;
    private LinearLayout linear;
    private int seconds=0;
    private boolean running = false;
    private ConstraintLayout consLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setupViews();
        getIntentData();
        populateSpinner();
        runTimer();

    }

    private void getIntentData() {
        Intent intent = getIntent();
        status = intent.getStringExtra("Status");
        exercises =  intent.getStringExtra("exercises");
        position = intent.getIntExtra("position",0);

        if (position == 0){
           consLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.legs));

        }
        else if (position == 1){
            consLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.chest));
        }
        else {
            consLayout.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.back));
        }
    }

    private void setupViews() {
        spinner = findViewById(R.id.spinner);
        txtDetails = findViewById(R.id.txtDetails);
        linear = findViewById(R.id.linear);
        consLayout=findViewById(R.id.consLayout);
    }

    private void runTimer() {
        final TextView txtTime = findViewById(R.id.txtTime);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600; //حساب الساعات
                int minutes = (seconds%3600) / 60; //حساب الدقائق
                int secs = seconds%60; //حساب الثواني
                String time = hours +" : " + minutes + " : " + secs; // فورمات اللي رح يظهر عال text view
                txtTime.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000); //عشان افهم الهاندلر انو يضل يعيد هاض الشغل كل 1000 ميلي ثانية ( يعني كل ثانية)

            }
        });
    }

    private void populateSpinner() {
        ExercisesFactory factory = new ExercisesFactory();
        InterfaceExercisesDataAccess objExercises = factory.getModel();

        String[] cats = objExercises.getLevel();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,cats);
        spinner.setAdapter(adapter);//to fill data in spinner
    }

    public void btnOnClickBegin(View view) {
        ExercisesFactory factory = new ExercisesFactory();
        InterfaceExercisesDataAccess objExercises = factory.getModel();
        String item = "";
        item = spinner.getSelectedItem().toString();
        List<Exercises> theTraining= objExercises.getExercises(item,exercises,status);
        String str = "";
        for (Exercises b : theTraining){
            str+=b.getHowToPlay() ;
          }
        if (item != ""){
            linear.setVisibility(View.VISIBLE);
            txtDetails.setText(str);
        }


    }

    public void btnOnClickStart(View view) {
        running = true;
    }

    public void btnOnClickStop(View view) {
        running = false;
    }

    public void btnOnClickReset(View view) {
        running = false;
        seconds = 0;
    }
}