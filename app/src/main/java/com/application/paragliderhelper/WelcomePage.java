package com.application.paragliderhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class WelcomePage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDataFromSharedPreferences(this);
        if (Data.getSelectedEnglish()){
            String languageToLoad = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }

        setContentView(R.layout.activity_welcome_page);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button aboutAppButton = findViewById(R.id.aboutAppButton);
        Button mapAppButton =findViewById(R.id.startButton);
        settingsButton.setOnClickListener(this);
        aboutAppButton.setOnClickListener(this);
        mapAppButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settingsButton:
                Intent intentSettingsPage = new Intent(this, SettingsPage.class);
                startActivity(intentSettingsPage);
                break;

            case R.id.aboutAppButton:
                Intent intentAboutApp =new Intent(this, AboutAppPage.class);
                startActivity(intentAboutApp);
                break;

            case R.id.startButton:
                Intent intent = new Intent(this, Accelerometer.class);
                startService(intent);
                Intent intentMapPage =new Intent(this, MapsPage.class);
                startActivity(intentMapPage);

                break;
        }
    }

    private static void initializeDataFromSharedPreferences(Context context){
        String PREFERENCES_NAME = "settingsSharedPreferences";
        SharedPreferences sharedPreferences;
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);

        Data.setFirstName(sharedPreferences.getString("firstname",""));
        Data.setSurname(sharedPreferences.getString("surname",""));
        Data.setCity(sharedPreferences.getString("city",""));

        Data.setPhoneNumber1(sharedPreferences.getString("phoneNumber1",""));
        Data.setPhoneNumber2(sharedPreferences.getString("phoneNumber2",""));
        Data.setPhoneNumber3(sharedPreferences.getString("phoneNumber3",""));


        Data.setValueSeekBarDown(sharedPreferences.getInt("valueSeekBarDown",1));
        Data.setValueSeekBarUp(sharedPreferences.getInt("valueSeekBarUp",1));

        Data.setSelectedEnglish(sharedPreferences.getBoolean("selectedEnglish",true));

    }

}