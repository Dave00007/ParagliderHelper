package com.application.paragliderhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AboutAppPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

    }

    @Override
    public void onBackPressed() {

        Intent intentWelcomePage = new Intent(this, WelcomePage.class);
        startActivity(intentWelcomePage);
    }
}
