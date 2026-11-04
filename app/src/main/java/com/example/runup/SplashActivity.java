package com.example.runup;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. קודם כל לטעון את העיצוב של המסך!
        setContentView(R.layout.activity_splash);

        // 2. עכשיו כשהמסך קיים, אפשר למצוא את התמונה
        ImageView logo = findViewById(R.id.logo_image);

        // 3. לטעון את האנימציה
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);

        // 4. להפעיל אותה
        logo.startAnimation(animation);
    }
}