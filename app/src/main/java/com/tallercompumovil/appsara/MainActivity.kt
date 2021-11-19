package com.tallercompumovil.appsara

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import java.util.*

//var boton: Button?=null
//var cajaFecha:EditText?=null


class MainActivity : AppCompatActivity(){
//class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var etNumero: EditText
    private lateinit var ettPersonName: EditText

    private lateinit var editText: EditText
    private lateinit var email: String
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.\\+[a-z]+"

    private lateinit var etDate:TextView
    private lateinit var textView9:TextView

    private lateinit var fech: TextView

    private lateinit var imageView2:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Correo
        editText = findViewById(R.id.editText)
        editText.typeface = ResourcesCompat.getFont(this, R.font.trek)
        email = editText.text.toString().trim()
        //Edad
        textView9 = findViewById<TextView>(R.id.textView9)
        textView9.typeface = ResourcesCompat.getFont(this, R.font.trek)
        //Numero
        etNumero = findViewById(R.id.etNumero)
        etNumero.typeface = ResourcesCompat.getFont(this, R.font.trek)
        //Name
        ettPersonName = findViewById(R.id.ettPersonName)
        ettPersonName.typeface = ResourcesCompat.getFont(this, R.font.trek)
        //etDate =findViewById(R.id.etDate)
        etDate = findViewById<TextView>(R.id.etDate)
        etDate.typeface =ResourcesCompat.getFont(this, R.font.trek)
        //fecha
        fech = findViewById<TextView>(R.id.fech)
        fech.typeface = ResourcesCompat.getFont(this, R.font.trek)
        //Imagen
        imageView2 = findViewById<ImageView>(R.id.imageView2)

        val but = findViewById<Button>(R.id.button_enviar)
        but.setOnClickListener {
            solicitar()
        }
        val button = findViewById<Button>(R.id.btnDate)
        button.setOnClickListener { view ->
            printAge(view)
        }
    }

    private fun printAge(view:View){
        var myCalendar = Calendar.getInstance()
        var year = myCalendar.get(Calendar.YEAR)
        var month = myCalendar.get(Calendar.MONTH)
        var day = myCalendar.get(Calendar.DAY_OF_MONTH)
        //myCalendar.set(Calendar.YEAR, year-100)
        //myCalendar.set(Calendar.MONTH,month-11)

        //Toast.makeText(this, "Inside function", Toast.LENGTH_LONG).show()
        val datePickerDialog = DatePickerDialog(this
            ,DatePickerDialog.OnDateSetListener{
                    view, year, month, day ->
                //Toast.makeText(this, "$year $month $day",Toast.LENGTH_LONG).show()
                //myCalendar.set(Calendar.YEAR, year-100)
                //val selectedDate = "$day/${month+1}/$year"
                    //var textDate = findViewById<TextView>(R.id.etDate)
                //textDate.text = selectedDate
                val selectedDate = "$day/${month+1}/"
                    //val selectedDate = "$day/${month+1}/$year"
                val selectedyear ="$year"
                    etDate.setText("$selectedDate")
                    fech.setText("$selectedyear")


                var dob = Calendar.getInstance()
                dob.set(year,month,day)

                var age = myCalendar.get(Calendar.YEAR)-dob.get(Calendar.YEAR)
                    if(myCalendar.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR))
                    {
                        age--
                    }
                //var textView9 = findViewById<TextView>(R.id.textView9)
                textView9.setText("$age")
                //textView9.setText("Age is $age years old")

                //var Age: String =textView2.text.toString()
                                               }
            ,year
            ,month
            ,day).show()
        //datePickerDialog.datePicker.minDate =
    }

    /*
        fun clickBoton(view: View) {
            android:onClick="clickBoton"
            var Nombre: String = ettPersonName.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Nombre", Nombre)

            //enviar parámetros al Activity 2
            /*
            val parametros = Bundle()

            parametros.putString("Nombre:","Sarai")
            parametros.putInt("Numero de cuenta:", 123456789)

            intent.putExtras(parametros)*/

            startActivity(intent)
        }*/
    private fun solicitar() {
        val nombre = ettPersonName.text.toString()
        val fecha = etDate.text.toString()
        val fecha_año=fech.text.toString()
        val image = R.drawable.gallo
        val image2 =R.drawable.perro
        val image3 = R.drawable.cerdo
        val image4 = R.drawable.rata
        val image5 =R.drawable.buey
        val image6 = R.drawable.tigre
        val image7=R.drawable.conejo
        val image8 = R.drawable.dragon
        val image9 = R.drawable.serpiente
        val image10 = R.drawable.caballo
        val image11 = R.drawable.cabra
        val image12 = R.drawable.mono
        // val fecha = cajaFecha?.text.toString()
        //etNumero = findViewById(R.id.etNumero)
        // val numero = Integer.valueOf(etNumero.text().toString())
        //val numero = etNumero.text.toString().toInt()
        val numero = etNumero.text.toString()
        val correo = editText.text.toString()
        val edad = textView9.text.toString()
        //val numero = Integer.parseInt(etNumero.text.toString())

        if (nombre.isNotEmpty() && fecha.isNotEmpty() && fecha_año>="1921" && fecha_año<="2021"
            && numero.toString().length==9 && correo.isNotEmpty()){

            val ventana_solicitud = Intent(this, MainActivity2::class.java)

            ventana_solicitud.putExtra("Nombre.",nombre)
            //ventana_solicitud.putExtra("image", image)
            ventana_solicitud.putExtra("Fecha.",fecha)
            ventana_solicitud.putExtra("Año.",fecha_año.toInt())
            ventana_solicitud.putExtra("Numero.",numero.toInt())
            ventana_solicitud.putExtra("Correo.",correo)
            ventana_solicitud.putExtra("Edad (Años cumplidos).",edad.toInt())

            if(fecha_año=="1921" || fecha_año=="1933"|| fecha_año=="1945"|| fecha_año=="1957"|| fecha_año=="1969"
                || fecha_año=="1981"|| fecha_año=="1993"|| fecha_año=="2005"|| fecha_año=="2017") {
                ventana_solicitud.putExtra("image", image)
            }else{
                    //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
                }
            if(fecha_año=="1922" || fecha_año=="1934"|| fecha_año=="1946"|| fecha_año=="1958"|| fecha_año=="1970"
                || fecha_año=="1982"|| fecha_año=="1994"|| fecha_año=="2006"|| fecha_año=="2018") {
                ventana_solicitud.putExtra("image", image2)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1923" || fecha_año=="1935"|| fecha_año=="1947"|| fecha_año=="1959"|| fecha_año=="1971"
                || fecha_año=="1983"|| fecha_año=="1995"|| fecha_año=="2007"|| fecha_año=="2019") {
                ventana_solicitud.putExtra("image", image3)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1924" || fecha_año=="1936"|| fecha_año=="1948"|| fecha_año=="1960"|| fecha_año=="1972"
                || fecha_año=="1984"|| fecha_año=="1996"|| fecha_año=="2008"|| fecha_año=="2020") {
                ventana_solicitud.putExtra("image", image4)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1925" || fecha_año=="1937"|| fecha_año=="1949"|| fecha_año=="1961"|| fecha_año=="1973"
                || fecha_año=="1985"|| fecha_año=="1997"|| fecha_año=="2009"|| fecha_año=="2021") {
                ventana_solicitud.putExtra("image", image5)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1926" || fecha_año=="1938"|| fecha_año=="1950"|| fecha_año=="1962"|| fecha_año=="1974"
                || fecha_año=="1986"|| fecha_año=="1998"|| fecha_año=="2010") {
                ventana_solicitud.putExtra("image", image6)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1927" || fecha_año=="1939"|| fecha_año=="1951"|| fecha_año=="1963"|| fecha_año=="1975"
                || fecha_año=="1987"|| fecha_año=="1999"|| fecha_año=="2011") {
                ventana_solicitud.putExtra("image", image7)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1928" || fecha_año=="1940"|| fecha_año=="1952"|| fecha_año=="1964"|| fecha_año=="1976"
                || fecha_año=="1988"|| fecha_año=="2000"|| fecha_año=="2012") {
                ventana_solicitud.putExtra("image", image8)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1929" || fecha_año=="1941"|| fecha_año=="1953"|| fecha_año=="1965"|| fecha_año=="1977"
                || fecha_año=="1989"|| fecha_año=="2001"|| fecha_año=="2013") {
                ventana_solicitud.putExtra("image", image9)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1930" || fecha_año=="1942"|| fecha_año=="1954"|| fecha_año=="1966"|| fecha_año=="1978"
                || fecha_año=="1990"|| fecha_año=="2002"|| fecha_año=="2014") {
                ventana_solicitud.putExtra("image", image10)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1931" || fecha_año=="1943"|| fecha_año=="1955"|| fecha_año=="1967"|| fecha_año=="1979"
                || fecha_año=="1991"|| fecha_año=="2003"|| fecha_año=="2015") {
                ventana_solicitud.putExtra("image", image11)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
            if(fecha_año=="1932" || fecha_año=="1944"|| fecha_año=="1956"|| fecha_año=="1968"|| fecha_año=="1980"
                || fecha_año=="1992"|| fecha_año=="2004"|| fecha_año=="2016") {
                ventana_solicitud.putExtra("image", image12)
            }else{
                //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }

            startActivity(ventana_solicitud)

        }else{

            val alerta: AlertDialog?= this.let{
                val constructor = AlertDialog.Builder(it)
                constructor.apply {
                    setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                        //Toast.makeText(context, "Rellena todo", Toast.LENGTH_SHORT).show()
                        Toast.makeText(context,resources.getString(R.string.error1),Toast.LENGTH_SHORT).show()
                    })
                    //setNegativeButton("No me interesa", DialogInterface.OnClickListener { dialogInterface, i ->
                    setNegativeButton(resources.getString(R.string.error2), DialogInterface.OnClickListener { dialogInterface, i ->
                        //Toast.makeText(context, "Tienes que rellenar todo", Toast.LENGTH_SHORT).show()
                        Toast.makeText(context,resources.getString(R.string.error3),Toast.LENGTH_SHORT).show()
                    })
                }
                if (etNumero.text.toString().length<9){
                //if (etNumero.text.toString().equals("")){
                    Toast.makeText(this,resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
                    etNumero.error = getString(R.string.value)
                }else{
                    if(fech.text.toString()<"1922" || fech.text.toString()>"2021"){
                        Toast.makeText(this,resources.getString(R.string.fecha_invalida),Toast.LENGTH_SHORT).show()
                }}
                //constructor.setMessage("Hay problema, un campo es inválido")
                constructor.setMessage(resources.getString(R.string.error4))
                    //.setTitle("Campos inválidos")
                    .setTitle(resources.getString(R.string.error5))
                constructor.create()
            }
            alerta?.show()
        }
    }

    fun validateEmail(view: View?) {
        if (email.matches(emailPattern.toRegex())) {
            //Toast.makeText(applicationContext, "Valid email address", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, resources.getString(R.string.correo_ok), Toast.LENGTH_SHORT).show()
        } else {
            //Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext, resources.getString(R.string.correo_mal), Toast.LENGTH_SHORT).show()
        }
    }
    }

/*
    private fun inicializarComponentes() {
        boton = findViewById(R.id.btnDate)
        cajaFecha = findViewById(R.id.etDate)
        boton?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val Dialogfecha = DatePickerFragment{year, month, day -> mostrarResultado(year,month,day) }
        Dialogfecha.show(supportFragmentManager,"DatePicker")
    }

    private fun mostrarResultado(year: Int, month: Int, day: Int){
        //private fun mostrarResultado(year: Int, month: Int, day: Int):String {
        cajaFecha?.setText("$year/$month+1/$day")
/*
        var año_Actual = Calendar.getInstance().get(Calendar.YEAR)
        var mes_Actual =Calendar.getInstance().get(Calendar.MONTH)
        var age = año_Actual-year
        if(year<año_Actual && month<mes_Actual){
            age--
        }
        val ageInt=age+1
        return ageInt.toString()*/
    }

    class DatePickerFragment (val listener: (year:Int, month: Int, day:Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener{

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val c = Calendar.getInstance()
            var year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            var day = c.get(Calendar.DAY_OF_MONTH)


            val picker = DatePickerDialog(requireActivity(),this, year, month ,day)
            picker.datePicker.maxDate = c.timeInMillis
            c.set(Calendar.YEAR, year-100)
            c.set(Calendar.MONTH,month-11)
            picker.datePicker.minDate = c.timeInMillis
            //RESTRINGIR AÑOS EN DATEPICKER HASTA 100 AÑOS ANTES DEL ACTUAL 2021 -> 1921-2021

            return picker
        }

        override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
            listener(year,month,day)
        }

    }


    fun clicks(view: View) {
        //if (ettPersonName.text.toString() == "" && etNumero.text.toString() == "" && editText.text.toString()=="") {
        if (ettPersonName.text.toString() == "" && etNumero.text.toString() == "" && editText.text.toString()=="" && etDate.text.toString()=="") {
                Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                ettPersonName.error = getString(R.string.requiere_inf)
                etNumero.error = getString(R.string.requiere_inf)
                editText.error = getString(R.string.requiere_inf)
                etDate.error = getString(R.string.requiere_inf)
                //cajaFecha?.error = getString(R.string.requiere_inf)
            } else {
                if (etNumero.text.toString() == "") {
                    Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                    etNumero.error = getString(R.string.requiere_inf)
                } else {
                    if (etNumero.text.toString().length < 9) {
                        Toast.makeText(this,resources.getString(R.string.ingresa_valor),Toast.LENGTH_SHORT).show()
                        etNumero.error = getString(R.string.ingresa_valor)
                    } else {
                        val numero = Integer.parseInt(etNumero.text.toString())
                    }
                }
                if (ettPersonName.text.toString() == "") {
                    Toast.makeText(this, resources.getString(R.string.requiere_inf), Toast.LENGTH_SHORT).show()
                    ettPersonName.error = getString(R.string.requiere_inf)
                } else {
                    // val nombre = String.parseString(ettPersonName.text.toString())
                }
                Toast.makeText(this, resources.getString(R.string.inf_correcta), Toast.LENGTH_SHORT).show()
            }
        }
*/
