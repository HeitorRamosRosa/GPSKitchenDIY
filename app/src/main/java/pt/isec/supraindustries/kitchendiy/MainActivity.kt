package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun loadInformacoes(view: View) {
        val intent = Intent(this,Informacoes::class.java)
        startActivity(intent)
    }
}