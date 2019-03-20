package com.example.claudia.trabalhooo2g1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView TotalPassos;
    private android.hardware.SensorManager SensorManager;
    private Sensor StepSensor;
    private int passos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TotalPassos = (TextView) findViewById(R.id.totalDpassos);

        SensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        StepSensor = SensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
    }
    //
    @Override
    protected void onResume() {
        super.onResume();
        SensorManager.registerListener(this, StepSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    //
    @Override
    protected void onStop() {
        super.onStop();
        SensorManager.unregisterListener(this, StepSensor);
    }
    //
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR){
            passos++;
            TotalPassos.setText(""+passos);
        }
    }
    //
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
