package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import pt.isec.supraindustries.kitchendiy.Model.DataHandler
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var locale: Locale
    private var currentLanguage = "pt"
    private var currentLang: String? = null

    companion object{
        var cLang: String = "ing"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Debug","[Loading Receitas]")
        DataHandler.LoadReceitas(applicationContext)
        Log.i("Debug","[Load Complete]")
        System.out.println("[In main - Showing Loaded Info]:")
        //Debugging Function
        DataHandler.ListaAllReceitasInfo()
        DataHandler.listaAllIngredientesNome()
        System.out.println("[In main - Done Showing Info]")

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
        if(localeName.equals("pt")){
            System.out.println("Setting language to pt")
            cLang="pt"
        }
        else if(localeName.equals("en")){
            System.out.println("Setting language to ing")
            cLang="ing"
        }

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
            finish()
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

    fun loadInformacoes(view: View) {
        val intent = Intent(this, Informacoes::class.java)
        startActivity(intent)
    }

    //enviar emails
    fun sendHtmlEmailReceita(view: View?) {
        val mailId = "grupo33GPS@gmail.com"
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mailId, null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nova receita")
        emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("<p><b>Quero sugerir uma nova receita</b></p>" + "<small><p>escreva aqui a receita</p></small>"))
        startActivity(Intent.createChooser(emailIntent, "Enviar email..."))
    }
    fun sendHtmlEmailIngrediente(view: View?) {
        val mailId = "grupo33GPS@gmail.com"
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mailId, null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Novo ingrediente")
        emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("<p><b>Quero sugerir um novo ingrediente</b></p>" + "<small><p>escreva aqui o(s) ingredientes</p></small>"))
        startActivity(Intent.createChooser(emailIntent, "Enviar email..."))
    }
}
