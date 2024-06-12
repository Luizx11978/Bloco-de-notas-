package com.example.blocodenotas

import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var info : TextView
    private lateinit var home_button: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        info = findViewById(R.id.info)
        home_button = findViewById(R.id.home_button)



        //caixa de dialogo disponibilizado pelo professor
        info.setOnClickListener{

            val tamanholetras_mensagem = TextView(this).apply { //personalizando o tamanho das letras e colocando padding pra ficar no meio
                text = "Gustavo Rodrigues Lima - 03337529\nMarcos Gian Barreto Carlos - 03338257\nLuiz Augusto Bomfim Batista - 03319661"
                textSize = 13f // colocando tamanhho da fonte (estava quebrando linha e teve que diminuir)
                setPadding(50, 50, 50, 50) // colocando o padding
            }
            //alerta onde irá mostrar o nome dos componentes
            val dialogo = AlertDialog.Builder(this@MainActivity)
            dialogo.setTitle("Desenvolvedores")
            dialogo.setView(tamanholetras_mensagem)
            dialogo.setNeutralButton("OK", null)
            dialogo.show()
        }

        //botão para ir para a tela home
        home_button.setOnClickListener{
            val tela_home = Intent(this,home::class.java)
            startActivity(tela_home)
        }


    }

}
