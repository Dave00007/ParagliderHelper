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
        Log.e("acc", "taaak");
    return START_STICKY;
}

//    @Override
//    public void onCreate() {
//        sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//        Sensor accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
//        //sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
//        Log.e("acc", "elozka");
//    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
            ax = sensorEvent.values[0];
            Log.e("onChenged", "jestt");
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
