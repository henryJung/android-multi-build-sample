package com.flitto.android.buildsystemsample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.google.android.gcm.GCMRegistrar;
import com.nostra13.universalimageloader.core.ImageLoader;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.second_activity_name));
        setSupportActionBar(toolbar);

        TextView contentTxt = (TextView) findViewById(R.id.second_content_txt);

        /**
         * Set ACCESS_NETWORK_STATE to Only AndoridManifest.xml of Glbal flavor
         */
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            contentTxt.setText(networkInfo.toString());
        } catch (RuntimeException e) {
            contentTxt.setText("RuntimeException Occured. please check android.permission.ACCESS_NETWORK_STATE!");
        }

        /**
         * ImageLoader was imported by particularly library-global folder
         */
        ImageLoader.getInstance();

        /**
         * GCM was imported by using Gradle
         */
        GCMRegistrar registrar;
    }
}
