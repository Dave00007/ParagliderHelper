package com.application.paragliderhelper;

import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.util.Locale;

public class SettingsPage extends AppCompatActivity implements View.OnClickListener {

    ImageButton englishButton;
    ImageButton polandButton;
    EditText firstNameEditText;
    EditText surnameEditText;
    EditText cityEditText;
    EditText phoneNumber1EditText;
    EditText phoneNumber2EditText;
    EditText phoneNumber3EditText;
    SeekBar freqSeekBarUp;
    SeekBar freqSeekBarDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        englishButton = findViewById(R.id.englishButton);
        polandButton = findViewById(R.id.polandButton);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        cityEditText = findViewById(R.id.cityEditText);
        phoneNumber1EditText = findViewById(R.id.phoneNumberEditText1);
        phoneNumber2EditText = findViewById(R.id.phoneNumberEditText2);
        phoneNumber3EditText = findViewById(R.id.phoneNumberEditText3);
        freqSeekBarDown = findViewById(R.id.freqSeekBarDown);
        freqSeekBarUp = findViewById(R.id.freqSeekBarUp);

        freqSeekBarDown.setProgress(Data.getValueSeekBarDown());
        freqSeekBarUp.setProgress(Data.getValueSeekBarUp());
        firstNameEditText.setText(Data.getFirstName());
        surnameEditText.setText(Data.getSurname());
        cityEditText.setText(Data.getCity());
        phoneNumber1EditText.setText(Data.getPhoneNumber1());
        phoneNumber2EditText.setText(Data.getPhoneNumber2());
        phoneNumber3EditText.setText(Data.getPhoneNumber3());
        freqSeekBarDown.setOnSeekBarChangeListener(seekBarDownChangeListener);
        freqSeekBarUp.setOnSeekBarChangeListener(seekBarUpChangeListener);

        englishButton.setEnabled(false);
        englishButton.setImageAlpha(100);  //argumet between 0-255 , 0 - invisible, 255 - 100% visible
        polandButton.setOnClickListener(this);
        englishButton.setOnClickListener(this);
    }

    SeekBar.OnSeekBarChangeListener seekBarUpChangeListener = new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Data.setValueSeekBarUp(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    };
    SeekBar.OnSeekBarChangeListener seekBarDownChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            Data.setValueSeekBarDown(i);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.englishButton:
                englishButton.setEnabled(false);
                englishButton.setImageAlpha(100);
                polandButton.setEnabled(true);
                polandButton.setImageAlpha(255);
                String languageToLoad = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                // this.setContentView(R.layout.activity_settings_page);


                break;

            case R.id.polandButton:
                polandButton.setEnabled(false);
                polandButton.setImageAlpha(100);
                englishButton.setEnabled(true);
                englishButton.setImageAlpha(255);
                String languageToLoad1 = ""; // your language
                Locale locale1 = new Locale(languageToLoad1);
                Locale.setDefault(locale1);
                Configuration config1 = new Configuration();
                config1.locale = locale1;
                getBaseContext().getResources().updateConfiguration(config1,
                        getBaseContext().getResources().getDisplayMetrics());
                //this.setContentView(R.layout.activity_settings_page);

                break;
        }
    }
}
