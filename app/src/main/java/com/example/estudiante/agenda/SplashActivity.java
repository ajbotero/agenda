package com.example.estudiante.agenda;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.estudiante.agenda.MainActivity;
import com.example.estudiante.agenda.Preferences.CacheManager;
import com.example.estudiante.agenda.R;

public class SplashActivity extends AppCompatActivity {

    private CacheManager cacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cacheManager = new CacheManager(this);

        int TIME = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if(cacheManager.isLoggin()){
                    i = new Intent(SplashActivity.this, MainActivity.class);
                                   }
                else {
                    i = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(i);
                finish();
            }

        }, TIME);
    }
}