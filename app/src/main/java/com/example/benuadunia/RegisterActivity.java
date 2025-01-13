package com.example.benuadunia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.nama);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.button);

        registerButton.setOnClickListener(v -> registerUser());
        ImageView gmailIcon = findViewById(R.id.gmail);
        ImageView instagramIcon = findViewById(R.id.instagram);
        ImageView whatsappIcon = findViewById(R.id.whatsappp);

        gmailIcon.setOnClickListener(v -> openGmail());
        instagramIcon.setOnClickListener(v -> openInstagram());
        whatsappIcon.setOnClickListener(v -> openWhatsapp());
    }
    private void openGmail() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:someone@example.com"));
        startActivity(intent);
    }

    private void openInstagram() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/your_username"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Instagram belum di instal", Toast.LENGTH_SHORT).show();
        }
    }
    private void openWhatsapp() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/your_phone_number"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp belum di instal", Toast.LENGTH_SHORT).show();
        }
    }


    public void registerUser() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Semua Harus di isi", Toast.LENGTH_SHORT).show();
        } else {
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "PasswordsConfirm harus sama dengan password", Toast.LENGTH_SHORT).show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Registration Berhasil")
                        .setMessage("Selamat Registrasi kamu telah berhasil, Apakah Kamu Ingin Login?")
                        .setPositiveButton("OK", (dialog, which) -> {
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        }
    }

    public void login(View view) {
        // Redirect to Login activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
