package com.flitto.android.buildsystemsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.title_activity_main));

        String title = "Application name : " + getString(R.string.app_name) + "\n"
                + "Flavor : " + BuildConfig.FLAVOR;

        TextView titleTxt = (TextView) findViewById(R.id.main_title);
        titleTxt.setText(title);
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
