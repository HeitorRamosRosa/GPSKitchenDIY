package pt.isec.supraindustries.kitchendiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class getNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_number)
    }

    fun loadNumber(view: View) {
        //var etNumberIndex = findViewById<EditText>(R.id.editTextNumber2)
        var index = Integer.parseInt(findViewById<EditText>(R.id.editTextNumber2).text.toString())
        var number = DataHandler.getNumber(index)
        var tv = findViewById<TextView>(R.id.textView)

        tv.setText(number.toString())
    }
}