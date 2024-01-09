package com.example.desafiodelgica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Desafio3 : AppCompatActivity() {

    lateinit var nomeAutor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio3)

        val btnLimparDadosD3 : Button = findViewById(R.id.desafio3_limpar_btn)
        val nomeDigitado: EditText = findViewById(R.id.recebe_nome_d3)
        val btnAlterarNome: Button = findViewById(R.id.btn_alterar_nome_d3)
        val nomeReorganizadoD3: TextView = findViewById(R.id.nome_reorganizado_d3)

        btnAlterarNome.setOnClickListener {
            if (validaNome(nomeDigitado).not()) {
                return@setOnClickListener
            }
            nomeReorganizadoD3.text = quebraString(nomeAutor)
        }
        btnLimparDadosD3.setOnClickListener{
            nomeDigitado.text.clear()
            nomeReorganizadoD3.text = ""
        }
    }

    fun validaNome(nomeDigitado: EditText): Boolean {
        var nomeDigitado = nomeDigitado.text.toString()

        return if (nomeDigitado.isNullOrBlank()) {
            Toast.makeText(applicationContext, "Digite um nome válido", Toast.LENGTH_SHORT).show()
            false
        } else {
            nomeAutor = nomeDigitado.uppercase()
            true
        }
    }

    fun quebraString(nomeDigitado: String): String {
        val stringQuebrada = nomeDigitado.trimEnd().split(" ")
        val char = stringQuebrada.dropLast(1).map { it.first()}

        return "${stringQuebrada.last()}, ${char.joinToString(". ")}."
    }
}

