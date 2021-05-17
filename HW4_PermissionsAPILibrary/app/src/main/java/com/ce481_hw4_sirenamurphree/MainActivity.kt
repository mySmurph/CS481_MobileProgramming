
package com.ce481_hw4_sirenamurphree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		val button_api = findViewById<Button>(R.id.button_api)
		button_api.setOnClickListener {
			var toActivity = Intent(this, API::class.java)
			startActivity(toActivity)
		}
		
		val button_library = findViewById<Button>(R.id.button_library)
		button_library.setOnClickListener {
			var toActivity = Intent(this, Library::class.java)
			startActivity(toActivity)
		}
		
		val button_permission = findViewById<Button>(R.id.button_permission)
		button_permission.setOnClickListener {
			var toActivity = Intent(this, Permission::class.java)
			startActivity(toActivity)
		}
		
	}
}