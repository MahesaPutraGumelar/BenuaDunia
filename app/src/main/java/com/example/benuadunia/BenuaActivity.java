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

public class BenuaActivity extends AppCompatActivity implements NegaraAdapter.OnItemClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_benua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String benua = getIntent().getStringExtra("benua");
        TextView textView = findViewById(R.id.namabenua);
        textView.setText(benua);
        String img = getIntent().getStringExtra("img");
        ImageView imageView = findViewById(R.id.imgbenua);
        imageView.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));

        RecyclerView recyclerView = findViewById(R.id.listNegara);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Map<String, String>> data = new ArrayList<>();
        if (benua.equals("Benua Asia")) {
            addNegara(data, "Indonesia", "ic_indonesia", "Ibukota Jakarta", "1.904.569 km²",
                    "Indonesia adalah negara kepulauan terbesar di dunia, terdiri dari lebih dari 17.000 pulau. " +
                            "Negara ini memiliki keanekaragaman budaya yang luar biasa dan kaya akan sumber daya alam.");
            addNegara(data, "Malaysia", "ic_malaysia", "Ibukota Kuala Lumpur", "329.847 km²",
                    "Malaysia merupakan negara multikultural dengan pengaruh Melayu, Tionghoa, dan India yang kuat. " +
                            "Negara ini juga terkenal dengan Menara Kembar Petronas, salah satu gedung tertinggi di dunia.");
            addNegara(data, "Singapura", "ic_singapore", "Ibukota Singapura", "728 km²",
                    "Singapura adalah negara kota yang dikenal sebagai pusat finansial global. " +
                            "Meskipun kecil, negara ini memiliki sistem transportasi yang sangat modern dan kehidupan urban yang dinamis.");
            addNegara(data, "Vietnam", "ic_vietnam", "Ibukota Hanoi", "331.212 km²",
                    "Vietnam adalah negara dengan sejarah yang kaya dan beragam, terkenal dengan situs-situs bersejarahnya seperti Ha Long Bay " +
                            "dan kota kuno Hoi An. Negara ini juga memiliki tradisi kuliner yang kaya.");
            addNegara(data, "Thailand", "ic_thailand", "Ibukota Bangkok", "513.120 km²",
                    "Thailand, dikenal sebagai Negeri Gajah Putih, adalah tujuan wisata populer yang menawarkan keindahan pantai, kuil megah, " +
                            "dan budaya yang ramah. Bangkok, ibu kotanya, adalah pusat perdagangan dan budaya negara ini.");
        } else if (benua.equals("Benua Amerika")) {
            addNegara(data, "USA", "ic_usa", "Ibukota Washington", "9.834.000 km²",
                    "Amerika Serikat adalah negara yang memiliki pengaruh besar di dunia dalam bidang ekonomi, politik, dan budaya. " +
                            "Negara ini juga memiliki berbagai lanskap yang luar biasa, dari Grand Canyon hingga New York City.");
            addNegara(data, "Canada", "ic_canada", "Ibukota Ottawa", "9.985.000 km²",
                    "Kanada adalah negara terbesar kedua di dunia, dikenal karena keindahan alamnya seperti Pegunungan Rocky, " +
                            "danau yang luas, serta budaya yang ramah. Kanada juga memiliki dua bahasa resmi, Inggris dan Prancis.");
            addNegara(data, "Mexico", "ic_mexico", "Ibukota Mexico City", "1.964.375 km²",
                    "Meksiko adalah negara yang kaya akan sejarah dan budaya, terkenal dengan peninggalan peradaban Aztek dan Maya. " +
                            "Negara ini juga dikenal dengan masakan khasnya seperti taco dan guacamole.");
            addNegara(data, "Brazil", "ic_brazil", "Ibukota Brasilia", "8.515.767 km²",
                    "Brasil adalah negara terbesar di Amerika Selatan dan rumah bagi Hutan Amazon, salah satu paru-paru dunia. " +
                            "Negara ini juga terkenal dengan karnavalnya yang penuh warna dan budaya sepak bola yang kuat.");
            addNegara(data, "Argentina", "ic_argentina", "Ibukota Buenos Aires", "2.780.400 km²",
                    "Argentina adalah negara dengan warisan budaya yang kaya, terkenal dengan tarian Tango, daging sapi berkualitas tinggi, " +
                            "dan lanskap alam yang spektakuler seperti Pegunungan Andes dan Patagonia.");
        } else if (benua.equals("Benua Afrika")) {
            addNegara(data, "South Africa", "ic_south_africa", "Ibukota Pretoria", "1.221.037 km²",
                    "Afrika Selatan adalah negara dengan sejarah yang kompleks dan terkenal dengan Taman Nasional Kruger, " +
                            "salah satu cagar alam terbesar di dunia. Negara ini memiliki tiga ibu kota: Pretoria, Cape Town, dan Bloemfontein.");
            addNegara(data, "Egypt", "ic_egypt", "Ibukota Cairo", "1.010.408 km²",
                    "Mesir adalah rumah bagi peradaban kuno yang terkenal dengan piramida, Sphinx, dan Sungai Nil. " +
                            "Negara ini memiliki sejarah ribuan tahun dan merupakan salah satu pusat budaya dan pendidikan di Afrika.");
            addNegara(data, "Nigeria", "ic_nigeria", "Ibukota Abuja", "923.768 km²",
                    "Nigeria adalah negara dengan populasi terbesar di Afrika dan kaya akan sumber daya alam, terutama minyak bumi. " +
                            "Negara ini memiliki budaya yang sangat beragam, dengan lebih dari 250 kelompok etnis.");
            addNegara(data, "Kenya", "ic_kenya", "Ibukota Nairobi", "580.367 km²",
                    "Kenya adalah tujuan wisata terkenal dengan safari dan satwa liar, terutama di Taman Nasional Maasai Mara. " +
                            "Negara ini juga memiliki Gunung Kenya, puncak tertinggi kedua di Afrika.");
            addNegara(data, "Tanzania", "ic_tanzania", "Ibukota Dodoma", "947.303 km²",
                    "Tanzania adalah rumah bagi Gunung Kilimanjaro, puncak tertinggi di Afrika. " +
                            "Negara ini juga terkenal dengan Taman Nasional Serengeti dan Pulau Zanzibar.");
        } else if (benua.equals("Benua Antartika")) {
            addNegara(data, "Antarctica", "ic_antarctica", "Ibukota McMurdo Station", "14.000.000 km²",
                    "Antartika adalah benua paling dingin dan terpencil di dunia. Benua ini tidak memiliki penduduk tetap " +
                            "dan sebagian besar terdiri dari lapisan es yang sangat tebal.");
            addNegara(data, "Fiji", "ic_fiji", "Ibukota Suva", "18.274 km²",
                    "Fiji adalah negara kepulauan yang terkenal dengan pantai tropis, terumbu karang, dan budaya lokal yang kaya. " +
                            "Negara ini terdiri dari lebih dari 300 pulau yang tersebar di Samudra Pasifik.");
        } else if (benua.equals("Benua Australia")) {
            addNegara(data, "Australia", "ic_australia", "Ibukota Canberra", "7.692.024 km²",
                    "Australia adalah negara benua yang terkenal dengan kehidupan margasatwa unik, seperti kanguru dan koala. " +
                            "Negara ini juga memiliki tempat ikonik seperti Sydney Opera House dan Great Barrier Reef.");
            addNegara(data, "New Zealand", "ic_new_zealand", "Ibukota Wellington", "268.021 km²",
                    "Selandia Baru dikenal karena keindahan alamnya yang dramatis, mulai dari pegunungan hingga danau. " +
                            "Negara ini juga merupakan lokasi pengambilan gambar trilogi Lord of the Rings.");
        } else if (benua.equals("Benua Eropa")) {
            addNegara(data, "Germany", "ic_germany", "Ibukota Berlin", "357.386 km²",
                    "Jerman adalah negara dengan ekonomi terbesar di Eropa dan memiliki sejarah yang mendalam. " +
                            "Negara ini terkenal dengan kastil, bir, dan festival Oktoberfest.");
            addNegara(data, "France", "ic_france", "Ibukota Paris", "551.695 km²",
                    "Prancis adalah pusat seni, mode, dan budaya. Paris, ibu kotanya, dikenal sebagai Kota Cinta " +
                            "dan merupakan rumah bagi Menara Eiffel.");
            addNegara(data, "Italy", "ic_italy", "Ibukota Rome", "301.340 km²",
                    "Italia adalah negara yang kaya akan sejarah dan seni, terkenal dengan Colosseum, masakan khasnya seperti pasta, " +
                            "dan kota romantis seperti Venesia.");
            addNegara(data, "Spain", "ic_spain", "Ibukota Madrid", "505.992 km²",
                    "Spanyol dikenal dengan keindahan pantainya, seni flamenco, dan arsitektur khas seperti Sagrada Familia di Barcelona. " +
                            "Ibukota Madrid memiliki budaya yang kaya dan hidup.");
            addNegara(data, "Portugal", "ic_portugal", "Ibukota Lisbon", "92.090 km²",
                    "Portugal terkenal dengan pantai-pantainya yang menakjubkan, kota tua yang indah, dan tradisi fado. Lisbon, ibu kotanya, adalah kota dengan pemandangan indah dan kehidupan malam yang semarak.");


        }

        NegaraAdapter adapter = new NegaraAdapter(data, this);
        recyclerView.setAdapter(adapter);

    }
    private void addNegara(List<Map<String, String>> dataBenua, String nama, String img, String ibukota, String luas, String deskripsi) {
        Map<String, String> data = new HashMap<>();
        data.put("img", img);
        data.put("nama", nama);
        data.put("ibukota", ibukota);
        data.put("luas", luas);
        data.put("deskripsi", deskripsi);
        dataBenua.add(data);
    }

    @Override
    public void onItemClick(Map<String, String> negara) {
        String namaNegara = negara.get("nama");
        String ibukotaNegara = negara.get("ibukota");
        String deskripsiNegara = negara.get("deskripsi");

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("nama", namaNegara);
        intent.putExtra("ibukota", ibukotaNegara);
        intent.putExtra("luas", negara.get("luas"));
        intent.putExtra("deskripsi", deskripsiNegara);
        intent.putExtra("img", negara.get("img"));
        startActivity(intent);
    }
}