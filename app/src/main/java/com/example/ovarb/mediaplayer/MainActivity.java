package com.example.ovarb.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    int audioId = R.raw.ohmss_short;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create MediaPlayer instance
        player = MediaPlayer.create(this, audioId);


        //find playbutton
        Button buttonPlay = (Button) findViewById(R.id.button_play);

        //set playbutton onclick listener
        buttonPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 displayMessage("Play is pressed");

                 int songDuration = player.getDuration();
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

    }



    private void displayMessage(String message) {
        //find display_action
        TextView displayAction = (TextView) findViewById(R.id.display_action);
        displayAction.setText(message);
    }

    public void playSong() {
        player.start();
    }

    public void pauseSong() {
        player.pause();
    }

    public void resetSong() {
        player.seekTo(0);
    }
}
