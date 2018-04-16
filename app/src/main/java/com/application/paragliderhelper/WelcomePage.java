package com.application.paragliderhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intentMaapPage =new Intent(this, MapsPage.class);
                startActivity(intentMaapPage);
                break;
        }
    }
}