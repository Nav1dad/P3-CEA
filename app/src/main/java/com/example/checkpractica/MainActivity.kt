package com.example.checkpractica

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etNombre: EditText = findViewById(R.id.editTextNombre)
        val rbMasculino: RadioButton = findViewById(R.id.radioButtonMasculino)
        val rbFemenino: RadioButton = findViewById(R.id.radioButtonFemenino)
        val cbJF: CheckBox = findViewById(R.id.checkBoxJF)
        val cbJVJ: CheckBox = findViewById(R.id.checkBoxJVJ)
        val cbC: CheckBox = findViewById(R.id.checkBoxC)
        val cbVT: CheckBox = findViewById(R.id.checkBoxVT)
        val etC: EditText = findViewById(R.id.editTextComentario)
        val btnIngresar: Button = findViewById(R.id.buttonIngresar)
        val tvResultado: TextView = findViewById(R.id.textViewResultado)

        // accion de el boton
        btnIngresar.setOnClickListener{
            val nombre = etNombre.text.toString()
            val comen = etC.text.toString()

            // chech de los RB
            val genero = when{
                rbMasculino.isChecked -> rbMasculino.text.toString()
                rbFemenino.isChecked -> rbFemenino.text.toString()
                else -> "No seleccionado"
            }

            val intereses = mutableListOf<String>()

            // agregar los intereses seleccionados
            if (cbJF.isChecked) intereses.add("Jugar Futboll")
            if (cbJVJ.isChecked) intereses.add("Jugar Video Juegos")
            if (cbC.isChecked) intereses.add("Caminatas")
            if (cbVT.isChecked) intereses.add("Ver Television")

            // Mostrar el mensaje
            val mensaje = "Mi nombre es $nombre, soy genero $genero, mis pasatiempos son ${intereses.joinToString ()}, Como te defines: $comen"
            tvResultado.text = mensaje
        }
    }
}