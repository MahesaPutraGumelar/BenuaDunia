package com.example.benuadunia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private boolean lihatpassword = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView gmailIcon = findViewById(R.id.gmail);
        ImageView instagramIcon = findViewById(R.id.instagram);
        ImageView whatsappIcon = findViewById(R.id.whatsappp);

        gmailIcon.setOnClickListener(v -> openGmail());
        instagramIcon.setOnClickListener(v -> openInstagram());
        whatsappIcon.setOnClickListener(v -> openWhatsapp());
    }

    // kumpulan fungsi
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

    public void login(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.equals("Mahesa@gmail.com") && password.equals("12345")) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Email dan password tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    public void daftar(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
