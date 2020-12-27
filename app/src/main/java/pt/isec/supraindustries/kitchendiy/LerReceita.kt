package pt.isec.supraindustries.kitchendiy

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_receita.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import android.content.Intent
import android.content.Context
import android.widget.Button
import java.io.File

class LerReceita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receita)
        val button: Button = findViewById(R.id.btnInicio)
        button.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        title = "KitchenDIY"
        ler()
    }
    fun ler() {
        var string: String? = ""
        val stringBuilder = StringBuilder()
        val `is`: InputStream = this.resources.openRawResource(R.raw.bolonhesa_de_lentilhas)

        val reader = BufferedReader(InputStreamReader(`is`))
        while (true) {
            try {
                if (reader.readLine().also { string = it } == null) break
            } catch (e: IOException) {
                e.printStackTrace()
            }
            stringBuilder.append(string).append("\n")
            tv_receita.text = stringBuilder
        }
        `is`.close()
    }
}