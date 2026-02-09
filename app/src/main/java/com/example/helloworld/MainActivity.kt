package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var btnGreet: Button
    private lateinit var tvGreeting: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar views
        etName = findViewById(R.id.etName)
        btnGreet = findViewById(R.id.btnGreet)
        tvGreeting = findViewById(R.id.tvGreeting)

        // Configurar listener do botão
        btnGreet.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isEmpty()) {
                tvGreeting.text = "Por favor, digite seu nome!"
                tvGreeting.setTextColor(getColor(android.R.color.holo_red_dark))
            } else {
                val greeting = "Olá, $name!"
                tvGreeting.text = greeting
                tvGreeting.setTextColor(getColor(android.R.color.holo_blue_dark))
            }
        }
    }
}
