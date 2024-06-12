package com.example.blocodenotas

import android.content.Intent //classe Intent para permitir a navegação entre atividades
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.LinearLayout

class home : AppCompatActivity() {
    private lateinit var area_das_notas: LinearLayout // Declarando a área onde as notas serão armazenadas ttemporariamente
    lateinit var buttonnovanota: Button // botão para criar uma nova nota

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonnovanota = findViewById(R.id.buttonnovanota) // Encontra o botão na tela .xml pelo id

        area_das_notas = findViewById(R.id.area_das_notas) // Encontra a área de notas na tela .cml pelo id

        buttonnovanota.setOnClickListener {
            mostrarcaixadealerta() //chamando aa função de alerta de nova nota
        }
    }

    private fun mostrarcaixadealerta() {
        val caixadialogo = AlertDialog.Builder(this) // Criando um AlertDialog para exibir o diálogo
        caixadialogo.setTitle("Nova Nota Trevosa") //título do diálogo

        val input_de_titulo = EditText(this) // Cria um EditText para adicionar o título da nota
        input_de_titulo.hint = "Título da Dark Nota"
        caixadialogo.setView(input_de_titulo)

        caixadialogo.setPositiveButton("Criar \uD83D\uDDA4 ") { dialog, which -> // criando o botão "Criar" do diálogo (emoji de um coração)
            val titulonota = input_de_titulo.text.toString() // Obtém o texto inserido no EditText
            if (titulonota.isNotEmpty()) { // Verifica se o texto que foi adicionado não está vazio
                adicionarnota(titulonota) // Adiciona a nova nota na tela
            }
        }
        caixadialogo.setNegativeButton("\uD83E\uDD87 Cancelar", null) // criando o botão "Cancelar" do diálogo(emoji de morcego)
        caixadialogo.show()
    }

    private fun adicionarnota(titulo: String) { // funcao para adicionar uma nova nota à tela
        val notaId = System.currentTimeMillis() // Gera um id único para a nota

        val textView = TextView(this).apply { // Cria um novo TextView para representar a nota

            text = titulo // Define o texto do TextView como o título da nota
            textSize = 18f // Define o tamanho do texto
            setPadding(32, 16, 0, 16) // Define o preenchimento do TextView



            setOnClickListener { // Define o comportamento ao clicar no TextView
                val intent = Intent(this@home, Nova_nota::class.java)
                intent.putExtra("nota_id", notaId) // passa o ID da nota para a próxima tela
                intent.putExtra("titulo_da_nota", titulo) // passa o título da nota para a próxima tela
                startActivity(intent) // inicia a tela
            }
        }
        area_das_notas.addView(textView) // Adiciona o TextView na área de notas na tela
    }
}


