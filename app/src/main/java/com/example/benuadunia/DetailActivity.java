package com.example.benuadunia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        TextView namaNegaraView = findViewById(R.id.nama_negara);
        TextView ibukotaView = findViewById(R.id.ibukota);
        TextView luasView = findViewById(R.id.luas);
        TextView deskripsiView = findViewById(R.id.deskripsi);
        ImageView imgBenderaView = findViewById(R.id.img_bendera);

        String namaNegara = getIntent().getStringExtra("nama");
        String ibukota = getIntent().getStringExtra("ibukota");
        String luas = getIntent().getStringExtra("luas");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String img = getIntent().getStringExtra("img");

        if (namaNegara != null) {
            namaNegaraView.setText(namaNegara);
        }
        if (ibukota != null) ibukotaView.setText(ibukota);
        if (luas != null) luasView.setText(luas);
        if (img != null) imgBenderaView.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));
        if (deskripsi != null) deskripsiView.setText(deskripsi);


        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}