package pt.isec.supraindustries.kitchendiy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.isec.supraindustries.kitchendiy.pt.isec.supraindustries.kitchendiy.DetailsActivity
import java.util.*
import kotlin.collections.ArrayList

class RecyclerView_Adapter (private var listaIngredientes: ArrayList<String>) :
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
        holder.itemView.select_ingredientes_container.setBackgroundColor(Color.TRANSPARENT)

        holder.itemView.select_ingredientes_text.setTextColor(Color.WHITE)
        holder.itemView.select_ingredientes_text.text = filtroListaIngredientes[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(mcontext, DetailsActivity::class.java)
            intent.putExtra("passselectedingrediente", filtroListaIngredientes[position])
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