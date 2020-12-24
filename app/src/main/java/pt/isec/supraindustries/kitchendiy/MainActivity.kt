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

        val cenas:Button = findViewById(R.id.btnEscolherIngredientes)
        cenas.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityEscolherIngredientes::class.java)
            startActivity(intent)
        }
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