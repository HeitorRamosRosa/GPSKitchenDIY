package pt.isec.supraindustries.kitchendiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class addNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_number)
    }

    fun addNumber(view: View)
    {
        var number = Integer.parseInt(findViewById<EditText>(R.id.editTextNumber).text.toString())
        DataHandler.addInt(number)
        Toast.makeText(this,"Number added. size: ${DataHandler.getSize()}",Toast.LENGTH_SHORT).show()
    }

}