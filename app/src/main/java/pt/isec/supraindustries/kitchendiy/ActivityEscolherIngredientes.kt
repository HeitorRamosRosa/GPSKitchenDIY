package pt.isec.supraindustries.kitchendiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_escolher_ingredientes.*
import java.util.*
import kotlin.collections.ArrayList


class ActivityEscolherIngredientes : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
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

//listagem de ingredientes

        val searchIcon = search_Ingredientes.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)
        val cancelIcon = search_Ingredientes.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)
        val textView = search_Ingredientes.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        ingredientesrv = findViewById(R.id.ingredientes_rv)
        ingredientesrv.layoutManager = LinearLayoutManager(ingredientesrv.context)
        ingredientesrv.setHasFixedSize(true)

        search_Ingredientes.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        listarIngredientes()
    }
    private fun listarIngredientes() {
        val lista = ListaDeIngredientes(this).getLista()
        val cenas = ArrayList<String>()
        for (i in lista.indices){
            cenas.add(lista[i])
        }
        adapter = RecyclerViewAdapter(cenas)
        ingredientesrv.adapter = adapter
    }

}
