package com.appsmontreal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Button buttonReset;
    Button buttonStart;
    Button buttonExit;
    EditText editTextTimer;
    SeekBar seekBarTime;
    final int MAX = 330;
    final double INITIALPOSITION = 0.30;


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
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarTime.setMax(MAX);
        seekBarTime.setProgress(100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
