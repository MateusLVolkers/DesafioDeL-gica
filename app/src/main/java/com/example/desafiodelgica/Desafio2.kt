package com.example.desafiodelgica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Desafio2 : AppCompatActivity() {

    lateinit var fraseDigitada: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafio2)

        val recebeFrase: EditText = findViewById(R.id.recebe_frase_d2)
        val btnCalcular: Button = findViewById(R.id.btn_calcular_d2)
        val resultadoTxt: TextView = findViewById(R.id.resultado_d2)

        btnCalcular.setOnClickListener {

            if (validaFrase(recebeFrase).not()){
                return@setOnClickListener
            }

            resultadoTxt.text = "Maior letra: ${retornaMaiorChar(fraseDigitada)}"


        }


    }

    fun validaFrase(recebeFrase : EditText): Boolean{

        val frase = recebeFrase.text.toString()

        return if (frase.isNullOrBlank()){
            Toast.makeText(applicationContext, "Digite uma frase válida", Toast.LENGTH_SHORT).show()
            false
        }else {
            fraseDigitada = frase.toLowerCase()
            true
        }
    }

    fun retornaMaiorChar(frase: String): String {

        var charList = frase.toCharArray()
        var maiorChar = Char.MIN_VALUE

        for (item in charList){

            if (item > maiorChar){
                maiorChar = item
            }
        }

        return maiorChar.toString()
    }




}