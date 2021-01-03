package pt.isec.supraindustries.kitchendiy

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import pt.isec.supraindustries.kitchendiy.Model.Receita

class RecyclerViewAdapter (private var listaIngredientes: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var filtroListaIngredientes = ArrayList<String>()

    lateinit var mcontext: Context

    class IngredientesHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        filtroListaIngredientes = listaIngredientes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val listaIngredientesView =
                LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        val sch = IngredientesHolder(listaIngredientesView)
        mcontext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return filtroListaIngredientes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.select_ingredientes_text.text = filtroListaIngredientes[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext, DetailsActivity::class.java)
            intent.putExtra("stuff", filtroListaIngredientes[position])
            mcontext.startActivity(intent)
            Log.d("Selected:", filtroListaIngredientes[position])
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filtroListaIngredientes = listaIngredientes
                } else {
                    val resultList = ArrayList<String>()
                    for (row in listaIngredientes) {
                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    filtroListaIngredientes = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filtroListaIngredientes
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filtroListaIngredientes = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }



}