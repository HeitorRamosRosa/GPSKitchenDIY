package pt.isec.supraindustries.kitchendiy


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*
import android.content.Context

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

import android.widget.Filter
import android.widget.Filterable

class DetailsActivity : AppCompatActivity() {
    lateinit var mcontext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var cenas = intent.getStringExtra("stuff")
        var comp = "Bolonhesa de Lentilhas"

        if (cenas==comp){
            //detail_ingredientes_text.text = "aaaaaaaaaaaaaaaaaa"
            loadReceita()
        }
            else {
                detail_ingredientes_text.text = intent.extras!!.getString("stuff")!!
            }
    }

    fun loadReceita() {
       // detail_ingredientes_text.text = "aaaaaaaaaaaaaaaaaa"
        val i = Intent(this, LerReceita::class.java)
        startActivity(i)
    }
}