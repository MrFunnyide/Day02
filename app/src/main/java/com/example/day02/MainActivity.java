package com.example.day02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // inisialisasi
    private EditText etPanjang, etLebar, etTinggi;
    private Button btnHasil;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // deklarasi => memasukkan nilai yang nanti nya di inputkan , kedalam masing masing variabel
        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);

        btnHasil = findViewById(R.id.btnHasil);

        tvHasil = findViewById(R.id.tvHasil);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = etPanjang.getText().toString();
                String lebar = etLebar.getText().toString();
                String tinggi = etTinggi.getText().toString();

                if (panjang.isEmpty()) {
                    etPanjang.setError("Panjang tidak boleh kosong");
                } else if (lebar.isEmpty()) {
                    etLebar.setError("Lebar tidak boleh kosong");
                } else if (tinggi.isEmpty()) {
                    etTinggi.setError("Tinggi tidak boleh kosong");
                } else {
                    int length = Integer.parseInt(panjang);
                    int width = Integer.parseInt(lebar);
                    int height = Integer.parseInt(tinggi);

                    int volume = length * width * height;

                    tvHasil.setText(String.valueOf(volume));;
                }
            }
        });
    }
}