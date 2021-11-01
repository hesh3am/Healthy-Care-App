package com.example.hesham.healthycare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.advice.AdviceMainActivity;
import com.example.alarmnotfication.AlarmMainActivity;
import com.example.alarm_medic.AlarmMedicActivity;
import com.example.alarm_food.AlarmFoodActivity;
import com.example.alarm_push.AlarmPushActivity;
import com.example.alarm_sleep.AlarmSleepActivity;
import com.example.push_trainning.activity.WelcomesplashActivity;
import com.example.quiz.QuizMainActivity;


/**
 * Created by Hesham on 08-Jun-19.
 */

public class Notfication extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notfication);
    }

    ////// Start Activites
    public void Medic(View view) {
        Intent intent = new Intent(Notfication.this, AlarmMedicActivity.class);
        startActivity(intent);
    }

    public void Sleep(View view) {
        Intent intent = new Intent(Notfication.this, AlarmSleepActivity.class);
        startActivity(intent);
    }

    public void push(View view) {
        Intent intent = new Intent(Notfication.this, AlarmPushActivity.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(Notfication.this, AlarmFoodActivity.class);
        startActivity(intent);
    }

    public void water(View view) {
        Intent intent = new Intent(Notfication.this, AlarmMainActivity.class);
        startActivity(intent);
    }
}
