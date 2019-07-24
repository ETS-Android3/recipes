package com.example.recipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.splashImage)
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        splashImage.startAnimation(animation);
        final Intent intent = new Intent(this, LoginActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
