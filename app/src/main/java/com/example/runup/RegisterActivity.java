package com.example.runup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 1. מוצאים את השדות והכפתור
        EditText etUsername = findViewById(R.id.et_reg_username);
        EditText etPassword = findViewById(R.id.et_reg_password);
        EditText etConfirmPassword = findViewById(R.id.et_reg_confirm_password);
        Button btnRegister = findViewById(R.id.btn_register);

        // 2. מאזינים ללחיצה על כפתור ההרשמה
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // בדיקת שם משתמש
                if (username.isEmpty()) {
                    etUsername.setError("נא להזין שם משתמש");
                    return;
                }

                // בדיקת אורך סיסמה
                if (password.length() < 6) {
                    etPassword.setError("הסיסמה חייבת להכיל לפחות 6 תווים");
                    return;
                }

                // בדיקת התאמת סיסמאות
                if (!password.equals(confirmPassword)) {
                    etConfirmPassword.setError("הסיסמאות אינן תואמות");
                    return;
                }

                // מעבר חזרה למסך ה-Login ושליחת הפרטים
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
                finish();
            }
        });
    }
}