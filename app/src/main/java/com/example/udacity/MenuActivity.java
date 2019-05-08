package com.example.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textViewitem1 = (TextView)findViewById(R.id.menu_item_1);
        String menuItem1 = textViewitem1.getText().toString();
        Log.v("MenuActivity",menuItem1);
        // Find second menu item TextView and print the text to the logs

        TextView textViewItem2 = (TextView) findViewById(R.id.menu_item_2);
        String menuItem2 = textViewItem2.getText().toString();
        Log.v("MenuActivity", menuItem2);
        // Find third menu item TextView and print the text to the logs
        TextView textViewItem3 = (TextView) findViewById(R.id.menu_item_3);
        String menuItem3 = textViewItem3.getText().toString();
        Log.v("MenuActivity", menuItem3);

    }
}
