package com.example.infod.appclima

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvClima:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)

        tvGrados = findViewById(R.id.tvGrados)

        tvClima = findViewById(R.id.tvClima)


        val ciudad = intent.getStringExtra("com.example.appclima.ciudades.CIUDAD")
        Toast.makeText(this,ciudad,Toast.LENGTH_LONG).show()
            if(Network.hayRed(this))
            {
                              solicitudHTPPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=555343654fffc73d994b773c92b9d7c8&units=metric&lang=es")

                // 555343654fffc73d994b773c92b9d7c8
                // Malaga 6359472
                // Fuengirola 2517595
                // Mostoles 3116025

            }else {
                Toast.makeText(this,"No hay red, conectese a una conexión red",Toast.LENGTH_LONG).show()

            }

    }
    private  fun solicitudHTPPVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET,url, Response.Listener<String>{
            response ->
            try {
                Log.d("SolicitudHTPPVolley", response)

                val gson = Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString() + "º"
                tvClima?.text = ciudad.weather?.get(0)?.description

            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }


    }



