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

    // משתנים לשמירת הנתונים שיגיעו מההרשמה
    private String registeredUser = "";
    private String registeredPass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        TextView tvRegister = findViewById(R.id.tv_register_link);

        // קליטת הנתונים שהגיעו ממסך ההרשמה (בדיקה שלא יהיו null)
        if (getIntent() != null) {
            String userExtra = getIntent().getStringExtra("username");
            String passExtra = getIntent().getStringExtra("password");

            if (userExtra != null && passExtra != null) {
                registeredUser = userExtra;
                registeredPass = passExtra;
            }
        }

        // כפתור התחברות
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // בדיקה האם השדות ריקים
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "נא למלא את כל השדות", Toast.LENGTH_SHORT).show();
                    return;
                }

                // בדיקה האם הפרטים תואמים למה שנרשם (או לברירת מחדל אם עוד לא נרשמו)
                if (username.equals(registeredUser) && password.equals(registeredPass)) {
                    Toast.makeText(LoginActivity.this, "התחברת בהצלחה", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "פרטים שגויים", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // מעבר למסך הרשמה
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}