package com.riluca.healthyair.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.riluca.healthyair.LoginActivity;
import com.riluca.healthyair.MainActivity;
import com.riluca.healthyair.R;

public class Splash extends AppCompatActivity {

    ImageView logo;
    TextView tvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //getSupportActionBar().hide();

        logo = (ImageView)findViewById(R.id.ivLogo);
        tvMensaje = (TextView)findViewById(R.id.tvMensajeInicio);

        Animation translate = AnimationUtils.loadAnimation(this,R.anim.fadin);
        Animation trans = AnimationUtils.loadAnimation(this,R.anim.leftin);

        logo.startAnimation(translate);
        tvMensaje.startAnimation(trans);

        openApp(true);
    }

    private void openApp(boolean locationPermission){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        },   5000);

    }
}
