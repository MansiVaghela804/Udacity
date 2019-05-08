package com.example.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LogExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_example);


//      Simple Email example
        int numberOfEmailsInInbox = 0;
        int numberOfDraftEmails = 2;
        String emailMessage = "You have " + numberOfEmailsInInbox + " emails. ";
        String draftMessage = "You have " + numberOfDraftEmails + " email drafts.";
        if (numberOfEmailsInInbox == 0) {
            emailMessage = "You have no new messages. ";
        }

        if (numberOfDraftEmails == 0) {
            draftMessage = "You have no new drafts.";
        }

        Log.v("InboxActivity", emailMessage);
        Log.v("InboxActivity", draftMessage);

//      1)  Weather example
        boolean isRaining = false;
        Log.v("WeatherActivity", "Thank you for using the WhetherWeather App.");
        if (isRaining) {
            Log.v("WeatherActivity", "It's raining, better bring an umbrella.");
        } else {
            Log.v("WeatherActivity", "It's unlikely to rain.");
        }
//      2) Weather example
        boolean isRaining1 = true;
        if (isRaining1) {
            Log.v("WeatherActivity", "It's raining, better bring an umbrella.");
        } else {
            Log.v("WeatherActivity", "It's unlikely to rain.");
        }
        Log.v("WeatherActivity", "Thank you for using the WhetherWeather App.");

//        smoothie  Example
        int numberOfSmoothiesTillPrize = 10;

        if (numberOfSmoothiesTillPrize > 9) {
            Log.v("SmoothieActivity", "Congratulations, you get a free smoothie!");
            numberOfSmoothiesTillPrize = numberOfSmoothiesTillPrize - 10;
        } else {
            Log.v("SmoothieActivity", "No free smoothie this time.");
        }
        Log.v("SmoothieActivity", "You currently have " + numberOfSmoothiesTillPrize + " out of 10 smoothies needed for your next free smoothie.");

//      Example
        int points = 1;
        if (points == 0){
            TextView txt = (TextView)findViewById(R.id.txt);
            ImageView img = (ImageView)findViewById(R.id.img);
            txt.setText("Loser");
            img.setImageResource(R.drawable.sad);
        }else {
            TextView txt = (TextView)findViewById(R.id.txt);
            ImageView img = (ImageView)findViewById(R.id.img);
            txt.setText("Winner");
            img.setImageResource(R.drawable.happy);
        }
//      itemcount example
        int itemCount = 8;
        if (itemCount>10){
            Toast.makeText(this, "You get 20% off", Toast.LENGTH_SHORT).show();
        }else if (itemCount>0){
            Toast.makeText(this, "Thank You !!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "You have an empty cart", Toast.LENGTH_SHORT).show();
        }

    }
}
