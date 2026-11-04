package com.example.runup;

import android.content.Intent;
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
        // יצירת "פועל משני" שיספור זמן ברקע (Thread)
        Thread timer = new Thread() {
            public void run() {
                try {
                    // שלב א': המתנה של 3 שניות (3000 אלפיות השנייה)
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // שלב ב': מה קורה כשהזמן נגמר? מעבר מסך!

                    // 1. הכנת ה"בקשה" למעבר מהמסך הנוכחי למסך ההתחברות
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);

                    // 2. הפעלת המעבר (פתיחת מסך ההתחברות) בפועל
                    startActivity(intent);

                    // 3. סגירת מסך הפתיחה (השמדה עצמית)
                    finish();
                }
            }
        };

// חובה לקרוא לפקודה הזו בסוף כדי שהטיימר באמת יתחיל לרוץ
        timer.start();
    }
}