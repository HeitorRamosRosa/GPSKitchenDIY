package pt.isec.supraindustries.kitchendiy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detail_ingredientes_text.text = intent.extras!!.getString("passselectedingredient")!!

    }
}
