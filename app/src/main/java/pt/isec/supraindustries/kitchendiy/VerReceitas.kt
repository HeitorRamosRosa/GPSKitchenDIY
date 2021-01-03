package pt.isec.supraindustries.kitchendiy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ver_receitas.*
import pt.isec.supraindustries.kitchendiy.Model.DataHandler
import pt.isec.supraindustries.kitchendiy.Model.Receita
import java.util.*
import kotlin.collections.ArrayList


class VerReceitas : AppCompatActivity() {
    //lateinit var adapter: RecyclerViewAdapter
    //lateinit var receitasrv: RecyclerView
    lateinit var listReceitas : ArrayList<Receita>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_receitas)

        title = "KitchenDIY"

        val button: Button = findViewById(R.id.btnInicio)
        button.setOnClickListener {
            finish()
        }

//listagem de receitas_V2
        var lvReceitas = findViewById<ListView>(R.id.receitas_rv)
        if(MainActivity.cLang.equals("pt")){
            listReceitas = DataHandler.receitas_pt
            lvReceitas.adapter=receitasoAdapter(listReceitas, applicationContext)
        }
        if(MainActivity.cLang.equals("ing")){
            listReceitas = DataHandler.receitas_ing
            lvReceitas.adapter=receitasoAdapter(listReceitas, applicationContext)
        }

        lvReceitas.setOnItemClickListener { parent, view, position, id ->
            DataHandler.NomeReceita = listReceitas[position].nome



            val intent = Intent(this, PrintReceita::class.java)
            startActivity(intent)
        }
//listagem de receitas



        val searchIcon = search_Receita.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)
        val cancelIcon = search_Receita.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)
        val textView = search_Receita.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)
/*
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
*/
        //listarreceitas()
    }
    private fun listarreceitas() {
        //val lista = Listas(this).getListaReceitas()
        //val cenas = ArrayList<String>()
        //for (i in lista.indices){
        //    cenas.add(lista[i])
        //}

        //adapter = RecyclerViewAdapter(DataHandler.getReceitas())
        //receitasrv.adapter = adapter
    }

    private class receitasoAdapter (rl : ArrayList<Receita>, myContext : Context) : BaseAdapter()
    {
        private val mContext : Context

        init{
            mContext = myContext
        }
        var receitaList = rl

        override fun getCount(): Int {
            return  receitaList.size
        }

        override fun getItem(p0: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val row = layoutInflater.inflate(R.layout.row_receita, viewGroup, false)

            Log.i("DEBUG_CREATE_RECEITA","Position on row: ${position}")
            val receitaName = row.findViewById<TextView>(R.id.row_receita_nome)
            receitaName.text = receitaList[position].nome
            return row
        }
    }

}
