package com.application.paragliderhelper;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class Accelerometer extends Service implements SensorEventListener {
    private  SensorManager mSensorManager;
    private  Sensor mAccelerometer;
    private Vibrations vibrations;
    double ax,ay,az;


//    public Accelerometer() {
//        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
//        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI, new Handler());

        vibrations = new Vibrations(this);
        //Log.e("acc", "taaak");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vibrations.vibreStop();
        Log.e("stop", "stop");
    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            ax = sensorEvent.values[0];
            //Log.e("onChenged", "jestt");

            //vibrations.vibreDown();
        }
//        if (ax<0){
//            Vibrations vibr = new Vibrations(this);
//            vibr.vibreDown();
//        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
