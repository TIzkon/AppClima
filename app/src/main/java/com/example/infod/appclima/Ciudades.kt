package com.example.infod.appclima

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciudades.*

class Ciudades : AppCompatActivity() {
    val TAG = "com.example.appclima.ciudades.CIUDAD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

    val bMalaga = findViewById<Button>(R.id.b_Malaga)
    val bFuengirola = findViewById<Button>(R.id.b_Fuengirola)
    val bMostoles = findViewById<Button>(R.id.b_Mostoles)

    bMalaga.setOnClickListener(View.OnClickListener
    {
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra(TAG,"6359472")
        startActivity(intent)
    })
    bFuengirola.setOnClickListener(View.OnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TAG,"2517595")
        startActivity(intent)
    })

    bMostoles.setOnClickListener(View.OnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(TAG,"3116025")
        startActivity(intent)

    })
}
}
