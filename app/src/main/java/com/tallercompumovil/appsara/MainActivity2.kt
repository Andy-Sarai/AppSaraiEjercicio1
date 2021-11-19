package com.tallercompumovil.appsara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras

        val NombreR = bundle?.getString("Nombre.","")
        val FechaR = bundle?.getString("Fecha.","")
        //ventana_solicitud.putExtra("Año.",fecha_año.toInt())
        val AñoR = bundle?.getInt("Año.", 0)
        val NumeroR = bundle?.getInt("Numero.",0)
        val CorreoR = bundle?.getString("Correo.","")
        val EdadR = bundle?.getInt("Edad (Años cumplidos).", 0)
        val ImageR=bundle?.getInt("image",0)
/*
        val NombreR = intent.getStringExtra("Nombre.")
        val FechaR = intent.getIntExtra("Fecha.",0)
        val NumeroR = intent.getIntExtra("Numero",0)
        val CorreoR = intent.getStringExtra("Correo.")*/

        //Identificación por ID
        val nombre_r = findViewById<TextView>(R.id.txt_NombreUsuario)
        val fecha_r = findViewById<TextView>(R.id.txt_FechaUsuario)
        val año_r = findViewById<TextView>(R.id.txt_AñoUsuario)
        val numero_r = findViewById<TextView>(R.id.txt_NumUsuario)
        val correo_r = findViewById<TextView>(R.id.txt_CorreoUsuario)
        val edad_r = findViewById<TextView>(R.id.txt_EdadUsuario)
        val image_r=findViewById<ImageView>(R.id.imageView)

        nombre_r.text = NombreR.toString()
        fecha_r.text = FechaR.toString()
        año_r.text = AñoR.toString()
        numero_r.text = NumeroR.toString()
        correo_r.text =CorreoR.toString()
        edad_r.text = EdadR.toString()

        ImageR?.let { image_r.setImageResource(it) }

/*val numero = Integer.parseInt(etNumero.getText().toString())
        val bundle = intent.extras

        val usuario_nombre = bundle?.getString("Nombre","")
        val envio = findViewById<TextView>(R.id.txt_NombreUsuario)
        envio.text = usuario_nombre.toString()
        //val ncuenta = bundle?.getInt("Numero de cuenta:", 0)
        //Toast.makeText(this,"Nombre:$usuario, Numero de cuenta:$ncuenta", Toast.LENGTH_LONG).show()*/
    }
}