package com.example.desafiodelgica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDesafio1: Button = findViewById(R.id.btn_desafio1)
        val btnDesafio2: Button = findViewById(R.id.btn_desafio2)
        val btnDesafio3: Button = findViewById(R.id.btn_desafio3)

        btn1Listener(btnDesafio1)
        btn2Listener(btnDesafio2)
        btn3Listener(btnDesafio3)


    }

    fun btn1Listener (btnDesafio1:Button) {

        btnDesafio1.setOnClickListener() {

            val intent = Intent(applicationContext, Desafio1::class.java)
            startActivity(intent)

        }
    }

        fun btn2Listener (btnDesafio2:Button){

            btnDesafio2.setOnClickListener(){

                val intent = Intent (applicationContext, Desafio2::class.java)
                startActivity(intent)

            }
        }

        fun btn3Listener (btnDesafio3:Button){

            btnDesafio3.setOnClickListener(){

                val intent = Intent (applicationContext, Desafio3::class.java)
                startActivity(intent)

            }
        }





}