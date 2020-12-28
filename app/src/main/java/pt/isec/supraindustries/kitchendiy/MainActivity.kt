package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var locale: Locale
    private var currentLanguage = "pt"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Debug","Doing load receitas")
        DataHandler.LoadReceitas(applicationContext, )
        Log.i("Debug","Load Receitas Done")
        System.out.println("In main: ")
        System.out.println(DataHandler.receitas[0].getInfo())
        System.out.println(DataHandler.receitas[1].getInfo())

        currentLanguage = intent.getStringExtra(currentLang).toString()
        spinner = findViewById(R.id.spinner)
        val list = ArrayList<String>()
        list.add("Select Language")
        list.add("Português")
        list.add("English")

        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("pt")
                    2 -> setLocale("en")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                    this,
                    MainActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                    this@MainActivity, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }
    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
        exitProcess(0)
    }
    fun loadEscolherIngredientes(view: View) {
        val intent = Intent(this, EscolherIngredientes::class.java)
        startActivity(intent)
    }

    fun loadVerReceitas(view: View) {
        val intent = Intent(this, VerReceitas::class.java)
        startActivity(intent)
    }

    fun loadAddNumber(view: View) {
        val intent = Intent(this, addNumber::class.java)
        startActivity(intent)
    }
    fun loadGetNumber(view: View) {
        val intent = Intent(this, getNumber::class.java)
        startActivity(intent)
    }
}