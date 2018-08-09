package com.example.ovarb.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    int audioId = R.raw.ohmss_short;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create MediaPlayer instance
        mPlayer = MediaPlayer.create(this, audioId);


        //find playbutton
        Button buttonPlay = (Button) findViewById(R.id.button_play);

        //set playbutton onclick listener
        buttonPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 displayMessage("Play is pressed");

                 int songDuration = mPlayer.getDuration();
                 displayMessage("" + songDuration);
                 playSong();

             }
        });



        //find pausebutton
        Button buttonPause = (Button) findViewById(R.id.button_pause);

        //set pausebutton onclick listener
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Pause is pressed");
                pauseSong();
            }
        });

        //find resetbutton
        Button buttonReset = (Button) findViewById(R.id.button_reset);

        //set resetbutton onclick listener
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Reset is pressed");
                resetSong();
            }
        });

        Button duckButton = (Button) findViewById(R.id.button_lower);

        //set duckButton onclick listener
        duckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Duck is pressed");
                duckVolume();
            }
        });

        Button unduckButton = (Button) findViewById(R.id.button_louder);

        //set unduckButton onclick listener
        unduckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Unduck is pressed");
                unduckVolume();
            }
        });

    }



    private void displayMessage(String message) {
        //find display_action
        TextView displayAction = (TextView) findViewById(R.id.display_action);
        displayAction.setText(message);
    }

    public void playSong() {
        mPlayer.start();
    }

    public void pauseSong() {
        mPlayer.pause();
    }

    public void duckVolume() {
        mPlayer.setVolume(0.3f, 0.3f);
    }

    public void unduckVolume() {
        mPlayer.setVolume(1f, 1f);
    }

    public void resetSong() {
        mPlayer.seekTo(0);
    }

    @Override
    protected void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {

        Log.i("MainActivity", "releaseMediaPlayer() is evoked");

        // If the media player is not null, then it may be currently playing a sound.
        if (mPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mPlayer.release();

            Log.i("MainActivity", "mMediaPlayer is released");

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mPlayer = null;
        }
    }

}
