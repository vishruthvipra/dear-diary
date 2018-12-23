package com.example.vishruthkrishnaprasad.deardiary;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.view.Window;
import android.widget.Toast;

import com.example.vishruthkrishnaprasad.deardiary.databinding.SplashBinding;

/**
 * This the welcome screen of the application.
 * It checks if the user is connected to the internet
 * Informs the user if the device is not connected to internet
 */

public class SplashActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    Boolean isInternetPresent = false;
    ConnectionDetector cd;
    Intent intent;
    SplashBinding splashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        cd = new ConnectionDetector(getApplicationContext());
        isInternetPresent = cd.isConnectingToInternet();

        // After 2000 ms the HomeActivity is started
        int SPLASH_DISPLAY_LENGTH = 2000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isInternetPresent)
                    Toast.makeText(SplashActivity.this, "Not connected to Internet!!", Toast.LENGTH_LONG).show();
                intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}


