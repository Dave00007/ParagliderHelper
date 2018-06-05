package com.application.paragliderhelper;

import android.content.Context;
import android.os.Vibrator;

public class Vibrations  {

    private Vibrator vibrator;
    Integer unit = 300;

    Vibrations(Context context){
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        assert vibrator != null;
    }

    void vibreDown(){
        long[] pattern = {0, unit * Data.getValueSeekBarDown(), 1000};
        vibrator.vibrate(pattern, -1);
    }
    void vibreUp(){
        long[] pattern = {0, unit * Data.getValueSeekBarUp(), 1000};
        vibrator.vibrate(pattern, -1);
    }

}
