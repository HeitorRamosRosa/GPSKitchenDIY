package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Debug","Doing load receitas")
        DataHandler.LoadReceitas(applicationContext, )
        Log.i("Debug","Load Receitas Done")
        System.out.println("In main: ")
        System.out.println(DataHandler.receitas[0].getInfo())
        System.out.println(DataHandler.receitas[1].getInfo())

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