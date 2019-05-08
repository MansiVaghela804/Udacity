package com.example.udacity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class JustJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("RRRRMMMMRRRRMMMMRRRRMMMM!!");
        textView.setTextSize(56);
        textView.setTextColor(Color.RED);
        textView.setMaxLines(2);
        setContentView(R.layout.activity_just_java);
//        setContentView(textView);
    }
}
