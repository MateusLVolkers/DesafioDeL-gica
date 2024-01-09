package com.example.desafiodelgica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Desafio1 : AppCompatActivity() {

    lateinit var nomeAluno: String
    var listaNotas = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio1)

        val btnLimpar: Button = findViewById(R.id.desafio1_limpar)
        val desafio1Resultado: TextView = findViewById(R.id.desafio1_resultado)
        val desafio1Nome: EditText = findViewById(R.id.desafio1_recebe_nome)
        val desafio1Nota1: EditText = findViewById(R.id.desafio1_recebe_notas)
        val desafio1Nota2: EditText = findViewById(R.id.desafio1_recebe_notas2)
        val desafio1Nota3: EditText = findViewById(R.id.desafio1_recebe_notas3)
        val desafio1Nota4: EditText = findViewById(R.id.desafio1_recebe_notas4)
        val desafio1BtnCalcular: Button = findViewById(R.id.btn_calcular_desafio1)

        desafio1BtnCalcular.setOnClickListener() {
            if (validaNome(desafio1Nome).not()) {
                return@setOnClickListener
            }
            if (validaNota(desafio1Nota1).not()) {
                return@setOnClickListener
            }
            if (validaNota(desafio1Nota2).not()) {
                return@setOnClickListener
            }
            if (validaNota(desafio1Nota3).not()) {
                return@setOnClickListener
            }
            if (validaNota(desafio1Nota4).not()) {
                return@setOnClickListener
            }

            var notaFinal = calculaMedia(listaNotas)
            desafio1Resultado.setText("Aluno = $nomeAluno // Média = ${String.format("%.2f", notaFinal)}")
            listaNotas.clear()
        }

        btnLimpar.setOnClickListener() {
            desafio1Nome.text.clear()
            desafio1Nota1.text.clear()
            desafio1Nota2.text.clear()
            desafio1Nota3.text.clear()
            desafio1Nota4.text.clear()
            desafio1Resultado.setText("")
        }
    }

    fun validaNome(desafio1Nome: EditText): Boolean {
        val nome = desafio1Nome.text.toString()

        return if (nome.isNullOrBlank()) {
            Toast.makeText(this, "Digite um nome válido", Toast.LENGTH_SHORT).show()
            false
        } else {
            nomeAluno = nome
            true
        }
    }

    fun validaNota(desafioNota: EditText): Boolean {
        val nota = desafioNota.text.toString().toIntOrNull() ?: -1

        return if (nota < 0 || nota > 10) {
            Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            false
        } else {
            listaNotas.add(nota)
            true
        }
    }

    fun calculaMedia(lista: MutableList<Int>): Double {
        var media = 0.0

        for (item in lista) {
            media += item.toDouble()
        }
        return media / lista.size
    }
}