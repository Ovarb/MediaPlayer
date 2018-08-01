package com.example.ovarb.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find playbutton
        Button buttonPlay = (Button) findViewById(R.id.button_play);

        //set playbutton onclick listener
        buttonPlay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 displayMessage("Play is pressed");
             }
        });



        //find pausebutton
        Button buttonPause = (Button) findViewById(R.id.button_pause);

        //set pausebutton onclick listener
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMessage("Pause is pressed");
            }
        });








    }

    private void displayMessage(String message) {
        //find display_action
        TextView displayAction = (TextView) findViewById(R.id.display_action);
        displayAction.setText(message);
    }
}
