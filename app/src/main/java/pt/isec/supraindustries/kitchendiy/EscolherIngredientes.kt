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
import kotlinx.android.synthetic.main.activity_escolher_ingredientes.*
import pt.isec.supraindustries.kitchendiy.Model.DataHandler
import pt.isec.supraindustries.kitchendiy.Model.Ingrediente
import pt.isec.supraindustries.kitchendiy.Model.Receita
import java.util.*
import kotlin.collections.ArrayList


class EscolherIngredientes : AppCompatActivity() {
//    lateinit var adapter: RecyclerViewAdapter
    lateinit var ingredientesrv: RecyclerView
    var Ingrediente : String = "Teste"
    var listaIngredientesEscolhidos = ArrayList<String>()
    lateinit var listaNomesIngredientes : MutableList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolher_ingredientes)

        title = "KitchenDIY"
        val button: Button = findViewById(R.id.btnInicio)

        button.setOnClickListener {
            //val i = Intent(this@EscolherIngredientes, MainActivity::class.java)
            //startActivity(i)
        }
        if(MainActivity.cLang.equals("pt"))
            listaNomesIngredientes = DataHandler.ingredientes_pt.toMutableList()
        else listaNomesIngredientes = DataHandler.ingredientes_ing.toMutableList()

        var lvIngredientes = findViewById<ListView>(R.id.lv_ingredientes)
        lvIngredientes.adapter = IngredientesAdapter(listaNomesIngredientes, applicationContext)
        lvIngredientes.setOnItemClickListener{ parent, view, position, id ->
            val ingrediente =listaNomesIngredientes[position]
            System.out.println("Clicked: "+ingrediente.toString())
            listaIngredientesEscolhidos.add(ingrediente.toString())
            System.out.println("listaIngredEscolhidos Size: "+listaIngredientesEscolhidos.size)
            for(nome in listaNomesIngredientes){
                if(nome.equals(ingrediente))
                    listaNomesIngredientes.remove(nome)
            }

            var lvSelecionado = findViewById<ListView>(R.id.lSelected)
            listaIngredientesEscolhidos.add(Ingrediente)
            lvSelecionado.adapter = SelecionadosAdapter(listaIngredientesEscolhidos, applicationContext)

            lvIngredientes.adapter = IngredientesAdapter(listaNomesIngredientes, applicationContext)
        }

        var lvSelecionado = findViewById<ListView>(R.id.lSelected)
        listaIngredientesEscolhidos.add(Ingrediente)
        lvSelecionado.adapter = SelecionadosAdapter(listaIngredientesEscolhidos, applicationContext)

//listagem de ingredientes

        val searchIcon = search_Receita.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)
        val cancelIcon = search_Receita.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)
        val textView = search_Receita.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        //ingredientesrv = findViewById(R.id.receitas_rv)
        //ingredientesrv.layoutManager = LinearLayoutManager(ingredientesrv.context)
        //ingredientesrv.setHasFixedSize(true)

        search_Receita.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //adapter.filter.filter(newText)
                return false
            }
        })

        listarIngredientes()
    }
    private fun listarIngredientes() {
        //val lista = Listas(this).getListaIngredientes()
        //val cenas = ArrayList<String>()
        //for (i in lista.indices){
        //    cenas.add(lista[i])
        //}

        //adapter = RecyclerViewAdapter(DataHandler.getIngredientes())
        //ingredientesrv.adapter = adapter
    }

    private class SelecionadosAdapter (rl : ArrayList<String>, myContext : Context) : BaseAdapter()
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

            Log.i("DEBUG_CREATE_INGRED","Position on row: ${position}")
            val receitaName = row.findViewById<TextView>(R.id.row_receita_nome)
            receitaName.text = receitaList[position].toString()
            return row
        }
    }

    private class IngredientesAdapter (il : List<String>, myContext : Context) : BaseAdapter()
    {
        private val mContext : Context

        init{
            mContext = myContext
        }
        var ingredienteList = il

        override fun getCount(): Int {
            return  ingredienteList.size
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

            Log.i("DEBUG_CREATE_INGRED","Position on row: ${position}")
            val ingName = row.findViewById<TextView>(R.id.row_receita_nome)
            ingName.text = ingredienteList[position].toString()
            return row
        }
    }

}
