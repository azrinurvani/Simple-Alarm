package com.mobile.azrinurvani.simplealarm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView plainText;
    TextView textView;
    MediaPlayer mediaPlayer;

    public void select(View view){
        plainText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        mediaPlayer = MediaPlayer.create(this,R.raw.alarm);
        try{
            int time = Integer.parseInt(plainText.getText().toString());

            //if you want to start application from fixed time then add to 90,100 milli-second
            final int milliSecond = (time * 1000) + 100;
            //value is needed in milli-second. so first we convert value/time into milli-second
            new CountDownTimer(milliSecond,1000){//1000 is equal to 1 second

                @Override
                public void onTick(long millisUntilFinished) {
                    textView.setText("00.0" +String.valueOf(millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                    textView.setText("Alarm");
                    mediaPlayer.start();
                }
            }.start();
        }catch (NumberFormatException e){
            Toast.makeText(this,"Enter Value in integer Only",Toast.LENGTH_LONG).show();
        }

    }

    public void stop(View view){
        mediaPlayer.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}