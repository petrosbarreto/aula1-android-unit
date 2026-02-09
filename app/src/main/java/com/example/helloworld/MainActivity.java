package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnGreet;
    private TextView tvGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar views
        etName = findViewById(R.id.etName);
        btnGreet = findViewById(R.id.btnGreet);
        tvGreeting = findViewById(R.id.tvGreeting);

        // Configurar listener do botão
        btnGreet.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (name.isEmpty()) {
                tvGreeting.setText("Por favor, digite seu nome!");
                tvGreeting.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            } else {
                String greeting = "Olá, " + name + "!";
                tvGreeting.setText(greeting);
                tvGreeting.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            }
        });
    }
}
