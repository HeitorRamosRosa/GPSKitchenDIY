package pt.isec.supraindustries.kitchendiy

import android.icu.text.Edits
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import kotlinx.android.synthetic.main.activity_print_receita.view.*
import pt.isec.supraindustries.kitchendiy.Model.DataHandler
import pt.isec.supraindustries.kitchendiy.Model.Ingrediente

class PrintReceita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_receita)
        fillText()
    }

    private fun fillText() {
        var tv_nome = findViewById<EditText>(R.id.receita_nome)
        var tv_ingredientes = findViewById<EditText>(R.id.receita_ingredientes)
        var tv_instrucoes = findViewById<EditText>(R.id.receita_instruções)
        val receita = DataHandler.getReceitaToPrint()

        tv_nome.setText(receita.nome.toString())


        for(ingrediente in receita.ingredientes){
            tv_ingredientes.setText(tv_ingredientes.text.toString() + ingrediente.nome.toString()+"\n")
        }

        var it = receita.indicacoes.iterator()

        while (it.hasNext()){
            tv_instrucoes.setText(tv_instrucoes.text.toString() + it.next() +"\n")
        }


    }
}