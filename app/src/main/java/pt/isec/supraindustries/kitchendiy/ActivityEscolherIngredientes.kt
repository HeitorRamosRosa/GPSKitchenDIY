package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import pt.isec.supraindustries.kitchendiy.RecyclerView_Adapter

class ActivityEscolherIngredientes : AppCompatActivity() {
    var ingredientes = arrayOf("Batatas", "Massa", "Massa de Tomate", "Queijo", "Arroz", "Salsichas", "Natas", "Lentilhas", "Carne Picada")
    lateinit var adapter: RecyclerView_Adapter
    lateinit var ingredientesrv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolher_ingredientes)
        title = "KitchenDIY"
        val button: Button = findViewById(R.id.btnInicio)
        button.setOnClickListener {
            val i = Intent(this@ActivityEscolherIngredientes, MainActivity::class.java)
            startActivity(i)
        }
    }
}
