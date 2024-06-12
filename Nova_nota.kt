package com.example.blocodenotas

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged // classe doAfterTextChanged para executar algo depois que o texto mudar
import android.content.Context // classe Context para acessar recursos e serviços

class Nova_nota : AppCompatActivity() {
    lateinit var voltar : TextView // Declararando o TextView para voltar à tela home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nova_nota)

        voltar = findViewById(R.id.voltar) // Localiza o TextView de voltar na tela .xml

        // localiza o TextView responsável por mostrar o título da nota e o EditText responsável por editar o conteúdo da nota
        val tituloTextView: TextView = findViewById(R.id.titulonota)
        val notaemtext: EditText = findViewById(R.id.notatext)

        // pega o id e o título da nota da Intent
        val notaId = intent.getLongExtra("nota_id", -1)
        val titulo_nota = intent.getStringExtra("titulo_da_nota")

        // coloca o texto do TextView como o título da nota
        tituloTextView.text = titulo_nota

        // Carrega o conteudo da nota salvo anteriormente
        val sharedPreferences = getSharedPreferences("DarkNote", Context.MODE_PRIVATE) //arquivo de preferências que vai ser acessível apenas pelo aplicativo
        val textoSalvo = sharedPreferences.getString("nota_texto_$notaId", "")
        notaemtext.setText(textoSalvo)

        // ira salva o conteúdo da nota quando o usuario alterar alguma coisa
        notaemtext.doAfterTextChanged { texto ->
            sharedPreferences.edit().putString("nota_texto_$notaId", texto.toString()).apply()
        }

        // botãoonde irá voltar para a tela home
        voltar.setOnClickListener{
            val nova_nota = Intent(this, home::class.java)
            startActivity(nova_nota)
        }
    }
}
