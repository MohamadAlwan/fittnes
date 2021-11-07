package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class BMI extends AppCompatActivity {
    public static final String STATUS = "STATUS";
    public static final String WEIGHT = "WEIGHT";
    public static final String HEIGHT = "HEIGHT";
    public static final String FLAG = "FLAG";
    public static final String FLAGBMI = "FLAGBMI";
    public static final String BMI_RESULT = "BMI";

    private EditText edtWeight ;
    private double BMI;
    private EditText edtHeight ;
    private TextView txtBMI_Result;
    private CheckBox chk;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private String status;
    private boolean flag = false; //عشان اعرف هل تم التسيف ولا لا
    private boolean calculateIsClicked = false; //if the user not calculate his BMI then he can't move to next step
    private boolean checkCahngeBmi = false; //اذا كانت المعلومات محفوظة والمستخدم مل تغير عالوزن او عالطول هاض بفحصلي اذا انحسبت ال BMI الجديدة
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setupViews();
        setupSharedPrefs();
        checkPrefs();
    }

    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG,false); // بنادي الجيت بوليان اللي بالشيرد بريفيرينس وبعطي اسمو اللي هو Flag اذا ما وجدو حط الديفولت تاعو false

        if(flag){ //اذا وجد الفلاج (يعني كانت قيمتو true )
            //بسترجع باقي المعلومات
            int weight = prefs.getInt(WEIGHT,0);
            int height = prefs.getInt(HEIGHT,0);
            String bmiResult = prefs.getString(BMI_RESULT,"");
            status = prefs.getString(STATUS,"");
            calculateIsClicked = prefs.getBoolean(FLAGBMI,false);
            txtBMI_Result.setText(bmiResult);
            txtBMI_Result.setVisibility(View.VISIBLE);
            edtWeight.setText(""+weight);
            edtHeight.setText(""+height);

            chk.setChecked(true);//حط قيمة CheckBox = true لانو اليوزر كان مختارو


        }
    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupViews() {
       edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        txtBMI_Result = findViewById(R.id.txtBMI_Result);
       chk = findViewById(R.id.chk);
    }

    public void onClickCalculateBMI(View view) {
      try {
          InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
          mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

          int Weight = prefs.getInt(WEIGHT,0);
          int Height = prefs.getInt(HEIGHT,0);

          int weight = Integer.parseInt(edtWeight.getText().toString());
          int height = Integer.parseInt(edtHeight.getText().toString());

          if (weight > 0 && height > 0 ) {
              double bmi = BMI(weight, height);
              BMI = Math.round(bmi*100.0)/100.0;
              status = Status(BMI);
              if( (weight != Weight || height != Height)) {
                  checkCahngeBmi = true;
              }
              calculateIsClicked = true;
              txtBMI_Result.setText("your BMI is "+ BMI  +", this is considered " + status);
              txtBMI_Result.setVisibility(View.VISIBLE);
          }
          else {
              Toast.makeText(this,"please inter correct information",Toast.LENGTH_SHORT).show();
          }
      }
    catch (Exception e){
        Toast.makeText(this,"please inter correct information",Toast.LENGTH_SHORT).show();
    }
    }
    //distribution the weight status
    private String Status(double bmi) {
        String status = "";
        if(bmi<18.5){
            status += "Under Weight";
        }
        else if (bmi>24.9)
            status += "Over Weight";
        else
            status += "Normal Weight";

        return status;
    }

    //calculate BMI
    public Double BMI(int weight,int height){
       double heightInMetre = (double) height/100;
       double bmi;
       bmi = weight/(heightInMetre*heightInMetre) ;
        return bmi;
    }

    public void onClickNext(View view) {
        if (!calculateIsClicked){
            Toast.makeText(this,"please calculate your BMI ",Toast.LENGTH_SHORT).show();
        }
        else{
            int Weight = prefs.getInt(WEIGHT,0);
            int Height = prefs.getInt(HEIGHT,0);

          //  Gson gson = new Gson();

            String h = edtHeight.getText().toString();
            int height = Integer.parseInt(h);
           // String gheight = gson.toJson(height);

            String w = edtWeight.getText().toString();
            int weight = Integer.parseInt(w);
           // String gweight = gson.toJson(weight);

            String bmiResult = txtBMI_Result.getText().toString();
           // String gbmiResult = gson.toJson(bmiResult);


            if(chk.isChecked()) { //اذا كابس عالتشيك بوكي (يعني قيمتها true)
                if (!flag) {
                    editor.putInt(HEIGHT,height);
                    editor.putInt(WEIGHT,weight);
                    editor.putString(BMI_RESULT,bmiResult);
                    editor.putString(STATUS,status);
                    editor.putBoolean(FLAG,true);
                    editor.putBoolean(FLAGBMI,true);
                    editor.commit();
                }

                else if(flag && (weight != Weight || height != Height)){
                    if (checkCahngeBmi) {
                        editor.putInt(HEIGHT, height);
                        editor.putInt(WEIGHT, weight);
                        editor.putString(BMI_RESULT, bmiResult);
                        editor.putString(STATUS,status);
                        editor.putBoolean(FLAG, true);
                        editor.putBoolean(FLAGBMI, true);
                        editor.commit();
                    }
                    else{
                        Toast.makeText(this,"To Save Changed You Must Calculate Your new BMI",Toast.LENGTH_LONG).show();
                    }
                }

        }
            Intent intent = new Intent(this,Trainings.class);
            intent.putExtra("Status",status);
            startActivity(intent);

    }

  }
}