package com.appsmontreal;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Button buttonReset;
    Button buttonStart;
    Button buttonExit;
    TextView textViewTimer;
    SeekBar seekBarTime;
    final int MAX = 730;
    final int INITIALPOSITION = 30;
    final String STRINGINITIALPOSITION = "00:30";
    int minutes;
    int seconds;
    long totalTimeInSeconds;
    CountDownTimer countDownTimer;
    Sound sound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        buttonReset = findViewById(R.id.buttonReset);
        buttonStart = findViewById(R.id.buttonStart);
        buttonExit = findViewById(R.id.buttonExit);
        buttonReset.setOnClickListener(this);
        buttonStart.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
        buttonReset.setEnabled(false);
        textViewTimer = findViewById(R.id.textViewTimer);
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarTime.setOnSeekBarChangeListener(this);
        seekBarTime.setMax(MAX);
        seekBarTime.setProgress(INITIALPOSITION);
        sound = new Sound(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonReset:
                sound.soundReset();
                seekBarTime.setProgress(INITIALPOSITION);
                textViewTimer.setText(STRINGINITIALPOSITION);
                countDownTimer.cancel();
                buttonStart.setEnabled(true);
                seekBarTime.setEnabled(true);
                break;
            case R.id.buttonStart:
                playCountDownTimer();
                buttonReset.setEnabled(true);
                seekBarTime.setEnabled(false);
                break;
            case R.id.buttonExit:
                sound.soundExit();
                finish();
                break;
            default:
                break;

        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        totalTimeInSeconds = (long) progress * 1000;
        minutes = progress / 60;
        seconds = progress - (minutes * 60);
        textViewTimer.setText(((minutes < 10)?"0" + minutes:minutes) + ":" + ((seconds <10)?"0" + seconds:seconds));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void playCountDownTimer(){
        countDownTimer = new CountDownTimer(totalTimeInSeconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(((minutes < 10)?"0" + minutes:minutes) + ":" + ((--seconds <10)?"0" + seconds:seconds));
                if (seconds == 0){
                    if (minutes != 0){
                        minutes--;
                    }
                    seconds = 60;
                }
            }

            @Override
            public void onFinish() {
                sound.soundGetFinishTimer();
                buttonStart.setEnabled(false);
            }
        }.start();
    }

}
