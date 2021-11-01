package com.example.step_counter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StepCounterMainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView stepCount;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepcounter_activity_main);
        stepCount = findViewById(R.id.text_steps);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, sensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        display();
    }


    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }
//hhhhhhhhhhhhhh
    public void reset(View view) {
        Tacker.callOnIncrement();
        Tacker.reset();
        display();
    }

    public void display() {
        stepCount.setText(Tacker.getValue() + "");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (running) {
            Tacker.callOnIncrement();
            Tacker.increment();
            display();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
