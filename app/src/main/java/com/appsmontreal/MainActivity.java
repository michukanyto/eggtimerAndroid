package com.appsmontreal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    final int MAX = 330;
    final double INITIALPOSITION = 0.30;
    int minutes;
    int seconds;
    String minutesString;
    String secondsString;


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
        textViewTimer = findViewById(R.id.textViewTimer);
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarTime.setOnSeekBarChangeListener(this);
        seekBarTime.setMax(MAX);
        seekBarTime.setProgress(100);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonReset:
                textViewTimer.setText("0:40");
                break;
            case R.id.buttonStart:
                break;
            case R.id.buttonExit:
                finish();
                break;
            default:
                break;

        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        minutes = progress / 60;
        minutesString = String.valueOf(minutes);
        seconds = progress - (minutes * 60);
        secondsString = String.valueOf(seconds);
        textViewTimer.setText(minutes + ":" + seconds);
        Toast.makeText(this,String.valueOf(progress),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
