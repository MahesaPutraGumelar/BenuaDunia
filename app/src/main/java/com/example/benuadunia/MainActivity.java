package com.example.benuadunia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the EditText and Button views
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        login = findViewById(R.id.login);

        // Adjust the padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set click listeners for the social media icons
        ImageView gmailIcon = findViewById(R.id.gmail);
        ImageView instagramIcon = findViewById(R.id.instagram);
        ImageView whatsappIcon = findViewById(R.id.whatsappp);

        gmailIcon.setOnClickListener(v -> openGmail());
        instagramIcon.setOnClickListener(v -> openInstagram());
        whatsappIcon.setOnClickListener(v -> openWhatsapp());
    }

    // Open Gmail when the Gmail icon is clicked
    private void openGmail() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:someone@example.com"));
        startActivity(intent);
    }

    // Open Instagram when the Instagram icon is clicked
    private void openInstagram() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/your_username"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Instagram app not installed", Toast.LENGTH_SHORT).show();
        }
    }

    // Open WhatsApp when the WhatsApp icon is clicked
    private void openWhatsapp() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/your_phone_number"));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp app not installed", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the 'login' button click
    public void login(View view) {
        // Get the email and password entered by the user
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Check if the email and password are correct
        if (email.equals("Mahesa@gmail.com") && password.equals("12345")) {
            // Start the HomeActivity if the credentials match
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            // Show an error message as a toast notification
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle the 'daftar' (register) button click
    public void daftar(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
