package com.application.paragliderhelper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

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
        polandButton.setOnClickListener(this);
        englishButton.setOnClickListener(this);

        if(Data.getSelectedEnglish()){
            englishButton.setEnabled(false);
            englishButton.setImageAlpha(100);  //argumet between 0-255 , 0 - invisible, 255 - 100% visible
            polandButton.setEnabled(true);
            polandButton.setImageAlpha(255);
        }
        else{
            englishButton.setEnabled(true);
            englishButton.setImageAlpha(255);  //argumet between 0-255 , 0 - invisible, 255 - 100% visible
            polandButton.setEnabled(false);
            polandButton.setImageAlpha(100);
        }

    }

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
                //this.setContentView(R.layout.activity_settings_page);
                Log.i("str","eng");
                Data.setSelectedEnglish(true);
                Intent intent = new Intent(this, SettingsPage.class);
                startActivity(intent);
                finish();

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
                Data.setSelectedEnglish(false);
                Log.i("str","polski");
                Intent intent1 = new Intent(this, SettingsPage.class);
                startActivity(intent1);
                finish();

                break;
        }
    }

    @Override
    public void onBackPressed() {

        String PREFERENCES_NAME = "settingsSharedPreferences";
        SharedPreferences sharedPreferences;
        sharedPreferences = this.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("firstname", String.valueOf(firstNameEditText.getText()));
        Data.setFirstName(String.valueOf(firstNameEditText.getText()));
        editor.putString("surname", String.valueOf(surnameEditText.getText()));
        Data.setSurname(String.valueOf(surnameEditText.getText()));
        editor.putString("city", String.valueOf(cityEditText.getText()));
        Data.setCity(String.valueOf(cityEditText.getText()));

        editor.putString("phoneNumber1", String.valueOf(phoneNumber1EditText.getText()));
        Data.setPhoneNumber1(String.valueOf(phoneNumber1EditText.getText()));
        editor.putString("phoneNumber2", String.valueOf(phoneNumber2EditText.getText()));
        Data.setPhoneNumber1(String.valueOf(phoneNumber2EditText.getText()));
        editor.putString("phoneNumber3", String.valueOf(phoneNumber3EditText.getText()));
        Data.setPhoneNumber1(String.valueOf(phoneNumber3EditText.getText()));

        editor.putInt("valueSeekBarDown", freqSeekBarDown.getProgress());
        Data.setValueSeekBarDown(freqSeekBarDown.getProgress());
        editor.putInt("valueSeekBarUp", freqSeekBarUp.getProgress());
        Data.setValueSeekBarUp(freqSeekBarUp.getProgress());

        editor.putBoolean("selectedEnglish", !englishButton.isEnabled());
        Data.setSelectedEnglish(!englishButton.isEnabled());

        editor.apply();

        Intent intentSettingsPage = new Intent(this, WelcomePage.class);
        startActivity(intentSettingsPage);

        Toast.makeText(this, "All changes saved", Toast.LENGTH_LONG).show();
    }

}
