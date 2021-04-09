/**
 * Sirena Murphree
 * CS481 Midterm
 * murph135
 */
package CS481.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goto_contraint = findViewById<Button>(R.id.btn_constraint)
        goto_contraint.setOnClickListener {
            startActivity(Intent(this, constraintlayout::class.java))
        }

        val goto_linearlayout = findViewById<Button>(R.id.btn_linear)
        goto_linearlayout.setOnClickListener {
            startActivity(Intent(this, linearlayout::class.java))
        }

        val goto_relitive = findViewById<Button>(R.id.btn_relitive)
        goto_relitive.setOnClickListener {
            startActivity(Intent(this, relitivelayout::class.java))
        }
    }
}