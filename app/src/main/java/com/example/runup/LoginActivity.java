package com.example.runup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. טוען את העיצוב
        setContentView(R.layout.activity_login);

        // 2. מוצאים את הרכיבים
        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        TextView tvRegister = findViewById(R.id.tv_register_link);

        // 3. פעולה לכפתור כניסה - בדרך הקלאסית
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // קריאת הטקסט
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // בדיקה אם אחד מהם ריק
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "התחברת בהצלחה", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 4. פעולה לקישור ההרשמה - בדרך הקלאסית
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // מעבר מסך למסך הרשמה
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}