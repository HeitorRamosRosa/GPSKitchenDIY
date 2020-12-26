package pt.isec.supraindustries.kitchendiy

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class LerReceita : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receita)
        title = "KitchenDIY"
    }
    fun readTextFile(view: View) {
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
            textView.text = stringBuilder
        }
        `is`.close()
        Toast.makeText(baseContext, stringBuilder.toString(),
            Toast.LENGTH_LONG).show()
    }
}