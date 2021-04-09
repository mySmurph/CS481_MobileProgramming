package CS481.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class relitivelayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relitivelayout)

        val spin_year = findViewById<Spinner>(R.id.r_spin_year)

        var startYear = 21
        var yearsArray = arrayOfNulls<Int>(10)
        for (i in yearsArray.indices) {
            yearsArray[i] = startYear++
        }
        var yearArrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, yearsArray)
        spin_year.adapter = yearArrayAdapter
    }
}