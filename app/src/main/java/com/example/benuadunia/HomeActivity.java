package com.example.benuadunia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity implements BenuaAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.listBenua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Map<String, String>> data = new ArrayList<>();
        addBenua(data, "Benua Asia", "benua_asia");
        addBenua(data, "Benua Amerika", "benua_amerika");
        addBenua(data, "Benua Afrika", "benua_afrika");
        addBenua(data, "Benua Antartika", "benua_antartika");
        addBenua(data, "Benua Australia", "benua_australia");
        addBenua(data, "Benua Eropa", "benua_eropa");

        BenuaAdapter adapter = new BenuaAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    private void addBenua(List<Map<String, String>> dataBenua, String nama, String img) {
        Map<String, String> data = new HashMap<>();
        data.put("img", img);
        data.put("nama", nama);
        dataBenua.add(data);
    }

    @Override
    public void onItemClick(Map<String, String> benua) {
        // Handle item click, for example, to show country details
        Intent intent = new Intent(HomeActivity.this, BenuaActivity.class);
        intent.putExtra("benua", benua.get("nama"));
        intent.putExtra("img", benua.get("img"));
        startActivity(intent);
    }
    public void profile (View view){
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
