package com.appsmontreal;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
    private Context context;
    private MediaPlayer mediaPlayer;

    public Sound(Context context) {
        this.context = context;
    }

    public void soundGetFinishTimer(){
        mediaPlayer = MediaPlayer.create(context,R.raw.rooster);
        playSound(mediaPlayer);
    }

    public void soundExit(){
        mediaPlayer = MediaPlayer.create(context,R.raw.woosh);
        playSound(mediaPlayer);
    }

    public void soundReset(){
        mediaPlayer = MediaPlayer.create(context,R.raw.tick);
        playSound(mediaPlayer);
    }

    private void playSound(MediaPlayer play){
        play.start();
        play.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaP) {
                mediaP.release();
            };
        });

    }
}
