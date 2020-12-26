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
import kotlinx.android.synthetic.main.activity_ver_receitas.*
import java.util.*
import kotlin.collections.ArrayList


class VerReceitas : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
    lateinit var receitasrv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_receitas)

        title = "KitchenDIY"

        val button: Button = findViewById(R.id.btnInicio)
        button.setOnClickListener {
            val i = Intent(this@VerReceitas, MainActivity::class.java)
            startActivity(i)
        }

//listagem de receitas

        val searchIcon = search_Receita.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)
        val cancelIcon = search_Receita.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)
        val textView = search_Receita.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        receitasrv = findViewById(R.id.receitas_rv)
        receitasrv.layoutManager = LinearLayoutManager(receitasrv.context)
        receitasrv.setHasFixedSize(true)

        search_Receita.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        listarreceitas()
    }
    private fun listarreceitas() {
        val lista = Listas(this).getListaReceitas()
        val cenas = ArrayList<String>()
        for (i in lista.indices){
            cenas.add(lista[i])
        }
        adapter = RecyclerViewAdapter(cenas)
        receitasrv.adapter = adapter
    }

}
